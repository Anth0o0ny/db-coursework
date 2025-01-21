package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.TrainingWithExercisesDto;
import com.anth0o0ny.backend.dto.mapper.TrainingWithExercisesMapper;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import com.anth0o0ny.backend.database.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final DB db;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseService(DB db, JdbcTemplate jdbcTemplate) {
        this.db = db;
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<TrainingWithExercisesDto> getExercisesByUserId(int userId) {
        List<TrainingWithExercises> trainings = db.getExercisesByUserId(userId);
        return trainings.stream()
                .map(TrainingWithExercisesMapper::toDto)
                .collect(Collectors.toList());
    }

    public void addExercise(String description, int count, int trainingId) {
        jdbcTemplate.update(Constants.INSERT_EXERCISE, description, count, trainingId);
    }
}
