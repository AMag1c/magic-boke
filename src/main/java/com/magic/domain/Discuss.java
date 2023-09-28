package com.magic.domain;

public class Discuss {
    private Integer articleId;
    private String userName;
    private String discussDetails;
    private Integer discussLike;
    private String createTime;
    private String modifyTime;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDiscussDetails() {
        return discussDetails;
    }

    public void setDiscussDetails(String discussDetails) {
        this.discussDetails = discussDetails;
    }

    public Integer getDiscussLike() {
        return discussLike;
    }

    public void setDiscussLike(Integer discussLike) {
        this.discussLike = discussLike;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "articleId=" + articleId +
                ", userName='" + userName + '\'' +
                ", discussDetails='" + discussDetails + '\'' +
                ", discussLike=" + discussLike +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
