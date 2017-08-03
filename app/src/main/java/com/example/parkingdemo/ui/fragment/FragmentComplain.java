package com.example.parkingdemo.ui.fragment;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkingdemo.R;
import com.example.parkingdemo.model.Message;
import com.example.parkingdemo.service.CarParkClient;
import com.example.parkingdemo.service.CarParkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ss on 1.8.2017.
 */

public class FragmentComplain extends Fragment {

    private EditText nameEditText, emailEditText, titleEditText, messageEditText;
    private Button sendMessageButton;
    private String userName, userEmail, userTitle, userMessage;
    private View view;

    CarParkService carParkService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_complain, container, false);

        init();

        return view;
    }

    private void init() {
        nameEditText = view.findViewById(R.id.nameEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        titleEditText = view.findViewById(R.id.titleEditText);
        messageEditText = view.findViewById(R.id.titleEditText);

        sendMessageButton = view.findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    getSendMessage();
                    return;
                }
            }
        });
    }

    public boolean validate() {
        boolean valid = true;
        userName = nameEditText.getText().toString();
        userEmail = emailEditText.getText().toString();
        userTitle = titleEditText.getText().toString();
        userMessage = messageEditText.getText().toString();

        if (userName.isEmpty() || userName.length() < 3) {
            nameEditText.setError("At least 3 characters");
            valid = false;
        } else {
            nameEditText.setError(null);
        }

        if (userEmail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            emailEditText.setError("Enter a valid email address.");
            valid = false;
        } else {
            emailEditText.setError(null);
        }

        if (userTitle.isEmpty() || userTitle.length() < 4 || userTitle.length() > 25) {
            titleEditText.setError("Between 4 and 25 alphanumeric characters.");
            valid = false;
        } else {
            titleEditText.setError(null);
        }

        if (userMessage.isEmpty() || userMessage.length() < 4) {
            messageEditText.setError("4 alphanumeric characters.");
            valid = false;
        } else {
            messageEditText.setError(null);
        }
        return valid;
    }

    private void getSendMessage() {
        try {
            carParkService = CarParkClient.getCarParkService();
            Call<Message> messageCall = carParkService.getMessageInsert(userName, userEmail, userTitle, userMessage);
            messageCall.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    if (response.body().getSuccess() == 1) {
                        Snackbar.make(getView(), response.body().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    if (response.body().getSuccess() == 0) {
                        Snackbar.make(getView(), response.body().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Snackbar.make(getView(), "Connection Failed With Server", Snackbar.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            Snackbar.make(getView(), "Connection Failed With Server", Snackbar.LENGTH_SHORT).show();
        }
    }
}
