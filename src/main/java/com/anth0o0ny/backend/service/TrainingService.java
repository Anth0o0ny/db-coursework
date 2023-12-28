package com.anth0o0ny.backend.service;
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
        String insertTrainingSql = "INSERT INTO TRAINING (COACH_ID, SPORTSMAN_ID) VALUES (?, ?)";
        jdbcTemplate.update(insertTrainingSql, coachId, sportsmanId);

        // ID только что созданной тренировки
        String getLastTrainingIdSql = "SELECT MAX(ID) FROM TRAINING";
        return jdbcTemplate.queryForObject(getLastTrainingIdSql, Integer.class);
    }
}