package me.shivzee.helper;

import java.util.regex.Pattern;

public class Username {
    private String username;


    public Username(String username){
        this.username = username;
    }

    public boolean isValid(){
        return Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9])[a-zA-Z0-9]$").matcher(this.username).find();
    }

    public Username update(String newUsername){
        this.username = newUsername;
        return this;
    }

    public String getUsername(){
        return this.username;
    }

    public String getGmail(){
        return this.username+"@gmail.com";
    }

}
