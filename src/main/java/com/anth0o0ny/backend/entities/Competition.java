package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.enums.Distance;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Competition {
    private int id;
    private String name;
    private String poolName;
    private Date startDate;
    private Date endDate;
    private Distance distance;

    public Competition() {
    }
    public Competition(int id, String name, String poolName, Date startDate, Date endDate, Distance distance) {
        this.id = id;
        this.name = name;
        this.poolName = poolName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }
}


