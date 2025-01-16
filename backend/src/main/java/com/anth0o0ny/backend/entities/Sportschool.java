package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.enums.PoolSize;

public class Sportschool {
    private int id;
    private String name;
    private PoolSize poolSize;

    public Sportschool() {
    }

    public Sportschool(int id, String name, PoolSize poolSize) {
        this.id = id;
        this.name = name;
        this.poolSize = poolSize;
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

    public PoolSize getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(PoolSize poolSize) {
        this.poolSize = poolSize;
    }
}
