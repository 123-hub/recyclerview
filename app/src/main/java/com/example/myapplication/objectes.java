package com.example.myapplication;

public class objectes {

    private int id;
    private String email;
    private String fistname;
    private String lastname;
    private String avatar;


    public objectes(int id, String email, String fistname, String lastname, String avatar) {
        this.id = id;
        this.email = email;
        this.fistname = fistname;
        this.lastname = lastname;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFistname() {
        return fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAvatar() {
        return avatar;
    }
}
