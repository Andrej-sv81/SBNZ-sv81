package com.ftn.sbnz.service.dto;

public class UserRegisterDTO {
    public String email;
    public String password;
    public String level;
    public String genre;
    public String goal;

    public UserRegisterDTO() {}

    public UserRegisterDTO(String email, String password, String level, String genre, String goal) {
        this.email = email;
        this.password = password;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
    }
}
