package com.example.billbro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.billbro.Controller.RegisterController;
import com.example.billbro.Service.UserService;
import com.example.billbro.User.User;
import com.example.billbro.adapters.UserListAdapter;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputUsername;
    private EditText inputPass;
    private UserService userService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            List<User> users = new HttpRequestProductList().execute().get();
            ListView listViewUsers = (ListView) findViewById(R.id.listVIewUser);
            listViewUsers.setAdapter(new UserListAdapter(users, getApplicationContext()));
        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(e.getMessage());
            builder.create().show();
        }
    }

    private class HttpRequestProductList extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... params) {
            UserService userService = new UserService();
            return userService.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
        }
    }


    /*public void btnSubmit(View view){
//        user = new User(inputUser.getTransitionName(), inputName.getTransitionName(),
//                inputEmail.getTransitionName(), inputPassw.getTransitionName());
        // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

// Add the Jackson message converter
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

// Make the HTTP GET request, marshaling the response from JSON to an array of Events
            User[] events = restTemplate.getForObject("http://192.168.1.21:8091/api/user", User[].class);

    }*/

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
