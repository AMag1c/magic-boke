package com.magic.domain;

public class User {

    private Integer userId;
    private String userName;
    private String oldPassword;
    private String password;
    private String passwordAgain;
    private String userIntroduction;
    private Integer userFanNum;
    private Integer userAttentionNum;
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public Integer getUserFanNum() {
        return userFanNum;
    }

    public void setUserFanNum(Integer userFanNum) {
        this.userFanNum = userFanNum;
    }

    public Integer getUserAttentionNum() {
        return userAttentionNum;
    }

    public void setUserAttentionNum(Integer userAttentionNum) {
        this.userAttentionNum = userAttentionNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", password='" + password + '\'' +
                ", passwordAgain='" + passwordAgain + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", userFanNum=" + userFanNum +
                ", userAttentionNum=" + userAttentionNum +
                ", email='" + email + '\'' +
                '}';
    }
}
