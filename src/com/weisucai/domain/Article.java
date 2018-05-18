package com.weisucai.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article implements Serializable {
    private Integer id;
    //序列化时可以为空
//    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Area area;  //area
    private String type;
    private Integer original;  //是否原创，1 0
    private String title;
    private String content;
    private Integer price;
    private LocalDateTime releaseTime;
    private String shortDate;
//    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private User ower;

    public String getShortDate() {
        return shortDate;
    }

    public void setShortDate(String shortDate) {
        this.shortDate = shortDate;
    }

    public User getOwer() {
        return ower;
    }

    public void setOwer(User ower) {
        this.ower = ower;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", area=" + area +
                ", type='" + type + '\'' +
                ", original=" + original +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", releaseTime=" + releaseTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOriginal() {
        return original;
    }

    public void setOriginal(Integer original) {
        this.original = original;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }
}
