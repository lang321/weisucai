package com.weisucai.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 提现记录
 */
public class WithdrawRecord implements Serializable {
    /**
     * id int primary key identity(1,1),
     userId int references tb_user(id),
     integral int ,
     money float,
     rechargeTime datetime
     */
    private Integer id;
    private User user;
    private Integer integral;
    private float money;
    private LocalDate withDrawTime;

    @Override
    public String toString() {
        return "WithdrawRecord{" +
                "id=" + id +
                ", user=" + user +
                ", integral=" + integral +
                ", money=" + money +
                ", withDrawTime=" + withDrawTime +
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

    public LocalDate getWithDrawTime() {
        return withDrawTime;
    }

    public void setWithDrawTime(LocalDate withDrawTime) {
        this.withDrawTime = withDrawTime;
    }
}
