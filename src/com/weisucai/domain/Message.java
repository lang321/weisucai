package com.weisucai.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 消息
 */
public class Message implements Serializable {
    /**
     * id int primary key identity(1,1),
     name nvarchar(255),
     releaseTime datetime,
     content text,
     userId int references tb_user(id),
     url varchar(255)
     */
    private Integer id;
    private String name;
    private LocalDate releaseTime;
    private String content;
    private User user;
    private String url;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseTime=" + releaseTime +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDate releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
