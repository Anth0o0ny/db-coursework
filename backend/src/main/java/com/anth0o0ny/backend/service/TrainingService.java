package com.anth0o0ny.backend.service;
import com.anth0o0ny.backend.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrainingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createTraining(int coachId, int sportsmanId) {
        jdbcTemplate.update(Constants.INSERT_TRAINING, coachId, sportsmanId);

        String getLastTrainingIdSql = Constants.SELECT_LAST_TRAINING_ID;
        return jdbcTemplate.queryForObject(getLastTrainingIdSql, Integer.class);
    }
}