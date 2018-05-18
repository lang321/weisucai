package com.weisucai.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 素材交易记录
 */
public class ArticleTransRecord  implements Serializable{
    private Integer id;
    private User seller;  //卖家
    private User buyer;//买家
    private Article article;
    private Integer price;
    private LocalDate transTime;//交易时间
    private String evalueation;//评价
    private String complaints;//投诉

    @Override
    public String toString() {
        return "ArticleTransRecord{" +
                "id=" + id +
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", article=" + article +
                ", price=" + price +
                ", transTime=" + transTime +
                ", evalueation='" + evalueation + '\'' +
                ", complaints='" + complaints + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getTransTime() {
        return transTime;
    }

    public void setTransTime(LocalDate transTime) {
        this.transTime = transTime;
    }

    public String getEvalueation() {
        return evalueation;
    }

    public void setEvalueation(String evalueation) {
        this.evalueation = evalueation;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }
}
