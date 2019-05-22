package edu.neu.his.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;

    public User(String username, String password, List<GrantedAuthority> grantedAuthorities) {

    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
