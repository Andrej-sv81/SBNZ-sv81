package com.ftn.sbnz.service.dto;

public class UserDataDTO {
    public String email;
    public String password;
    public String level;
    public String genre;
    public String goal;
    public int songNumber;

    public UserDataDTO() {}

    public UserDataDTO(String email, String password, String level, String genre, String goal, int songNumber) {
        this.email = email;
        this.password = password;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
        this.songNumber = songNumber;
    }
}
