package com.magic.domain;

import java.sql.Timestamp;

public class Article {
    private Integer articleId;
    private String userName;
    private String articleDetails;
    private Integer articleTransmit;
    private Integer articleDiscuss;
    private Integer articleLike;
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

    public String getArticleDetails() {
        return articleDetails;
    }

    public void setArticleDetails(String articleDetails) {
        this.articleDetails = articleDetails;
    }

    public Integer getArticleTransmit() {
        return articleTransmit;
    }

    public void setArticleTransmit(Integer articleTransmit) {
        this.articleTransmit = articleTransmit;
    }

    public Integer getArticleDiscuss() {
        return articleDiscuss;
    }

    public void setArticleDiscuss(Integer articleDiscuss) {
        this.articleDiscuss = articleDiscuss;
    }

    public Integer getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(Integer articleLike) {
        this.articleLike = articleLike;
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
        return "Article{" +
                "articleId=" + articleId +
                ", userName='" + userName + '\'' +
                ", articleDetails='" + articleDetails + '\'' +
                ", articleTransmit=" + articleTransmit +
                ", articleDiscuss=" + articleDiscuss +
                ", articleLike=" + articleLike +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
