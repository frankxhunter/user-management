package com.models.schema;

import com.util.Validation;

public class User {
    private String id = null;

    private String username = null; 
    
    private String email = null;

    private String password = null;

    public User(){}

    public User(String username,String  email,String  password){
       this.setUsername(username);
       this.setPassword(password);
       this.setEmail(email);
    }
    public User(String username,String  email,String  password , String id){
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setId(id);
     }

    public void setUsername(String username) {
        if(Validation.username(username) )
        this.username = username;
        else{
            throw new IllegalArgumentException();
        }
    }
    public void setEmail(String email) {
        if(Validation.email(email))
        this.email = email;
        else{
            throw new IllegalArgumentException();
        }
    }
    public void setPassword(String password) {
        if(Validation.password(password))
        this.password = password;

        else{
            throw new IllegalArgumentException();
        }
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
