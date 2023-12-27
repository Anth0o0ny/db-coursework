package com.anth0o0ny.backend.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pool {
    private int id = 1;
    private String name;
    private String poolSize = "50";

//    public Pool(int id) {
//        this.id = 1;
//    }

    public Pool() {
    }

    @JsonCreator
    public Pool(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("poolSize") String poolSize) {
        this.id = id;
        this.name = name;
        this.poolSize = poolSize;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("poolSize")
    public String getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(String poolSize) {
        this.poolSize = poolSize;
    }

    @Override
    public String toString() {
        return "Pool[" +
                "id=" + id +
                ", name='" + name +
                ", poolSize=" + poolSize +
                ']';
    }
}