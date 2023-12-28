package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.database.DB;

public class Exercise {
    private int id;
    private String description;
    private int count;
    private int trainingId;


    public Exercise() {
    }

    public Exercise(int id, String description, int count, int trainingId) {
        this.id = id;
        this.description = description;
        this.count = count;
        this.trainingId = trainingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }
}

