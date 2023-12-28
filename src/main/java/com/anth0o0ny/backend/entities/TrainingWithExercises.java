package com.anth0o0ny.backend.entities;

import java.util.ArrayList;
import java.util.List;

public class TrainingWithExercises extends Training {
    private int id;
    private int coachId;
    private int sportsmanId;
    private List<Exercise> exercises;


    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
    public void addExercise(Exercise exercise) {
        if (exercises == null) {
            exercises = new ArrayList<>();
        }
        exercises.add(exercise);
    }

}
