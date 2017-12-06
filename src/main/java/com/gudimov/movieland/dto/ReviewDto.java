package com.gudimov.movieland.dto;

import com.gudimov.movieland.entity.Review;
import com.gudimov.movieland.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ReviewDto {
    private int id;
    private String text;
    private UserDto user;

    public ReviewDto(Review review) {
        this.id = review.getId();
        this.text = review.getText();
        this.user = new UserDto(review.getUser());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = new UserDto(user);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }

    public void setUser(List<User> userList) {
        if (userList.size() > 0) {
            user = new UserDto(userList.get(0));
        }
    }

    public static List<ReviewDto> convertEntityToDtoList(List<Review> reviewList) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            reviewDtoList.add(new ReviewDto(review));
        }
        return reviewDtoList;
    }
}
