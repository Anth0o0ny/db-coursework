package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TrainingService {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TrainingService.class);

    @Autowired
    public TrainingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createTraining(int coachId, int sportsmanId) {
        try {
            jdbcTemplate.update(Constants.INSERT_TRAINING, coachId, sportsmanId);

            String getLastTrainingIdSql = Constants.SELECT_LAST_TRAINING_ID;
            int lastTrainingId = jdbcTemplate.queryForObject(getLastTrainingIdSql, Integer.class);

            if (lastTrainingId <= 0) {
                logger.warn(Constants.WARNING_FAILED_TO_RETRIEVE_LAST_TRAINING_ID, coachId, sportsmanId);
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FAILED_TO_RETRIEVE_LAST_TRAINING_ID);
            }

            return lastTrainingId;

        } catch (Exception e) {
            logger.error(Constants.ERROR_CREATING_TRAINING, coachId, sportsmanId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_CREATING_TRAINING);
        }
    }
}
