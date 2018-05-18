package com.weisucai.domain;

import java.io.Serializable;

/**
 * 用户搜索记录表
 */
public class SearchRecord implements Serializable {
    private Integer id;
    private User user;
    private String search;

    @Override
    public String toString() {
        return "SearchRecord{" +
                "id=" + id +
                ", user=" + user +
                ", search='" + search + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
