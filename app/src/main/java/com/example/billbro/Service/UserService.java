package com.example.billbro.Service;

import com.example.billbro.User.BCryptPassword;
import com.example.billbro.User.User;

import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class   UserService {
    private RestTemplate restTemplate;
    private BCryptPassword bCryptPassword;
    private User user;
    private String baseUrl = "http://192.168.1.21:8091/api/user";

//    public UserService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }




    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try{
            return (List<User>) restTemplate.exchange(baseUrl + "user",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
            }).getBody();
        }catch (Exception e){
            return users;
        }
    }

    public User getUser(int u_id){
        try{
            return (User) restTemplate.exchange(baseUrl + "userfind/"+u_id,
                    HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
                    }).getBody();
        }catch (Exception e){
            return null;
        }
    }

    public boolean create() {
        try {
            Map<String, String> values = new HashMap<String, String>();
            values.put("username", user.getUsername());
            values.put("name",user.getName());
            values.put("email", user.getEmail());
            values.put("password", user.getPassword());
            JSONObject jsonObject = new JSONObject(values);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), headers);
            restTemplate.postForEntity(baseUrl + "usercreate", entity, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public User getUser(int u_id){
//        String url = "http://192.168.1.21:8091/api/user/"+u_id;
//        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url,User.class);
//        return responseEntity.getBody();
//    }

    public void openUser(User user){
        String url = "http://localhost:8091/api/user/";
        restTemplate.postForObject(url,user, User.class);
    }

    public boolean updateUser(User user){
        try {
            Map<String, String> values = new HashMap<String, String>();
            values.put("u_id", String.valueOf(user.getU_id()));
            values.put("username", user.getUsername());
            values.put("name",user.getName());
            values.put("email", user.getEmail());
            values.put("password", user.getPassword());
            JSONObject jsonObject = new JSONObject(values);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), headers);
            restTemplate.postForEntity(baseUrl + "userupdate", entity, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteUser(int u_id){
        try {
            restTemplate.delete(baseUrl + "userdelete/" + u_id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String hash(User user){
        bCryptPassword = new BCryptPassword(user);
        bCryptPassword.encryptPassword();
        return bCryptPassword.getHashed();
    }

    public User checkPin(User user){
        bCryptPassword = new BCryptPassword(getUser(user.getU_id()));
        if ((bCryptPassword.decryptPassword(user.getPassword()))){
            return user;
        }else {
            return null;
        }
    }
}

