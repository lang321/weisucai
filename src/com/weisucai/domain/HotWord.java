package com.weisucai.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 热词记录
 */
public class HotWord implements Serializable {
    private Integer id;
    private String name;
    private Integer weekTimes;
    private Integer monthTimes;
    private LocalDate lastTime;

    @Override
    public String toString() {
        return "HotWord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weekTimes=" + weekTimes +
                ", monthTimes=" + monthTimes +
                ", lastTime=" + lastTime +
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

    public Integer getWeekTimes() {
        return weekTimes;
    }

    public void setWeekTimes(Integer weekTimes) {
        this.weekTimes = weekTimes;
    }

    public Integer getMonthTimes() {
        return monthTimes;
    }

    public void setMonthTimes(Integer monthTimes) {
        this.monthTimes = monthTimes;
    }

    public LocalDate getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDate lastTime) {
        this.lastTime = lastTime;
    }
}
