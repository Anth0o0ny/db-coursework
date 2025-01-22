package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.TrainingWithExercisesDto;
import com.anth0o0ny.backend.dto.mapper.TrainingWithExercisesMapper;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import com.anth0o0ny.backend.database.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final DB db;
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ExerciseService.class);

    @Autowired
    public ExerciseService(DB db, JdbcTemplate jdbcTemplate) {
        this.db = db;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TrainingWithExercisesDto> getExercisesByUserId(int userId) {
        try {
            List<TrainingWithExercises> trainings = db.getExercisesByUserId(userId);
            if (trainings == null || trainings.isEmpty()) {
                logger.warn(Constants.WARNING_NO_EXERCISES_FOUND_FOR_USER, userId);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_EXERCISES_FOR_USER);
            }

            return trainings.stream()
                    .map(TrainingWithExercisesMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_EXERCISES, userId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_PROCESSING_REQUEST);
        }
    }

    public void addExercise(String description, int count, int trainingId) {
        try {
            if (description == null || description.isEmpty()) {
                logger.warn(Constants.WARNING_EMPTY_EXERCISE_DESCRIPTION, trainingId);
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.ERROR_EMPTY_DESCRIPTION);
            }
            if (count <= 0) {
                logger.warn(Constants.WARNING_INVALID_EXERCISE_COUNT, trainingId);
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.ERROR_INVALID_EXERCISE_COUNT);
            }
            jdbcTemplate.update(Constants.INSERT_EXERCISE, description, count, trainingId);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_ADDING_EXERCISE, trainingId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_PROCESSING_REQUEST);
        }
    }

}
