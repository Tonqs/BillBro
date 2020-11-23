package com.example.billbro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputUsername;
    private EditText inputPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

//    public void test(View view){
//        String username = inputUsername.getText().toString();
//        String password = inputPass.getText().toString();
//        if ((username.equals(controllerHomePage.getUsername())) && (password.equals(controllerHomePage.getPassword()))) {
//            Toast toast = Toast.makeText(this,"login successful",Toast.LENGTH_SHORT);
//            toast.show();
//        } else {
//            Toast toast = Toast.makeText(this,inputUsername.getText() + "" + inputPass.getText(),Toast.LENGTH_SHORT);
//            toast.show();
//        }
//        //Toast toast = Toast.makeText(this,"wrong username or password",Toast.LENGTH_SHORT);
//        //toast.show();
//            System.out.println(username);
//            System.out.println(password);
//    }
}
