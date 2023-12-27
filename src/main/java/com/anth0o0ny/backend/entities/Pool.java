package com.anth0o0ny.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pool {
    private final int id;
    private String name;
    private String poolSize;

    public Pool(int id) {
        this.id = id;
    }


    // Геттеры и сеттеры

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