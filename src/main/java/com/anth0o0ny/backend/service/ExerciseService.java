package com.anth0o0ny.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addExercise(String description, int count, int trainingId) {
        String insertExerciseSql = "INSERT INTO EXERCISE (DESCRIPTION, COUNT, TRAINING_ID) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertExerciseSql, description, count, trainingId);
    }
}
