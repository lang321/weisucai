package com.weisucai.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 公告记录
 */
public class Statements implements Serializable {
    /**
     * id int primary key identity(1,1),
     title nvarchar(255),
     conent text,
     releaseTime datetime
     */
    private Integer id;
    private String title;
    private String content;
    private LocalDate releaseTime;

    @Override
    public String toString() {
        return "Statements{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDate releaseTime) {
        this.releaseTime = releaseTime;
    }
}
