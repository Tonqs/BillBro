package com.example.billbro.Service;

import com.example.billbro.User.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class UserService {
    private RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getUsers(){
        String url = "http://localhost:8091/api/user/";
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(url, User[].class);

        User[] users = responseEntity.getBody();
        return Arrays.asList(users);
    }

    public User getUser(int id){
        String url = "http://localhost:8091/api/user/"+id;
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url,User.class);
        return responseEntity.getBody();
    }

    public void openUser(User user){
        String url = "http://localhost:8091/api/user/";
        restTemplate.postForObject(url,user, User.class);
    }

    public void editUser(User user){
        String url = "http://localhost:8091/api/user/"+user.getU_id();
        restTemplate.put(url,user);
    }

    public void deleteUser(User user){
        String url = "http://localhost:8091/api/user/"+user.getU_id();
        restTemplate.delete(url,user);
    }

}

