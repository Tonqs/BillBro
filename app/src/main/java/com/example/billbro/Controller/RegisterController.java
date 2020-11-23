package com.example.billbro.Controller;

import android.widget.EditText;

import com.example.billbro.User.User;

public class RegisterController {
    private EditText inputUser, inputName, inputEmail, inputPassw, inputConFPassw;

    private User user;

    public void btnSubmit(){
        user = new User(inputUser.getTransitionName(), inputName.getTransitionName(),
                inputEmail.getTransitionName(), inputPassw.getTransitionName());

    }
}