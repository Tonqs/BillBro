package com.example.billbro.User;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptPassword {
    private User user;
    private String hashed;

    public BCryptPassword(User user) {
        this.user = user;
    }

    public void encryptPassword() {
        hashed = BCrypt.hashpw(this.user.getPassword(),BCrypt.gensalt(10));
    }
    public boolean decryptPassword(String password){
        return BCrypt.checkpw(password, user.getPassword());
    }
    public String getHashed() {
        return hashed;
    }

    public User getUser() {
        return user;
    }
}
