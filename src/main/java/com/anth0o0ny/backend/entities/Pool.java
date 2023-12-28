package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.enums.PoolSize;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pool {
    private int id;
    private String name;
    private PoolSize poolSize;

    public Pool() {
    }

    public Pool(int id,
                String name,
                PoolSize poolSize) {
        this.id = id;
        this.name = name;
        this.poolSize = poolSize;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public PoolSize getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(PoolSize poolSize) {
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