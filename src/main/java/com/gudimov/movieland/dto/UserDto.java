package com.gudimov.movieland.dto;

import com.gudimov.movieland.entity.User;

public class UserDto {
    private int id;
    private String nickName;

    public UserDto(User user) {
        id = user.getId();
        nickName = user.getNickName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
