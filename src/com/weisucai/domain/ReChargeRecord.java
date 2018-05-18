package com.weisucai.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 充值记录
 */
public class ReChargeRecord implements Serializable {
    private Integer id;
    private  User user;
    private Integer integral;//积分数
    private float money;
    private LocalDate rechargeTime;

    @Override
    public String toString() {
        return "ReChargeRecord{" +
                "id=" + id +
                ", user=" + user +
                ", integral=" + integral +
                ", money=" + money +
                ", rechargeTime=" + rechargeTime +
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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public LocalDate getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(LocalDate rechargeTime) {
        this.rechargeTime = rechargeTime;
    }
}
