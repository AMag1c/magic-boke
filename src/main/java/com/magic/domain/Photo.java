package com.magic.domain;

public class Photo {
    private Integer photoId;
    private String  userName;
    private String photoPath;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", userName='" + userName + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
