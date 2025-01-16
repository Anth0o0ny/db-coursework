package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import com.anth0o0ny.backend.database.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final DB db;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseService(DB db, JdbcTemplate jdbcTemplate) {
        this.db = db;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TrainingWithExercises> getExercisesByUserId(int userId) {
        return db.getExercisesByUserId(userId);
    }

    public void addExercise(String description, int count, int trainingId) {
        jdbcTemplate.update(Constants.INSERT_EXERCISE, description, count, trainingId);
    }
}
