package com.anth0o0ny.backend.database;

import com.anth0o0ny.backend.entities.*;
import com.anth0o0ny.backend.mapper.TrainingWithExercisesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DB {

    @Autowired
    JdbcTemplate template;

    public DB() {
    }

    public List<Person> getSportsmanByName(String fullName) {
        String sql = "SELECT * FROM sportsman WHERE FULL_NAME = ?";
        return template.query(sql, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Sportsman> getSportsmanById(int id) {
        String sql = "SELECT s.ID, s.FULL_NAME, s.YOB, s.RANK, ss.NAME AS SPORTSCHOOL_NAME " +
                "FROM sportsman s " +
                "JOIN sports_school ss ON s.SPORTSCHOOL_ID = ss.ID " +
                "WHERE s.ID = ?";

        return template.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Sportsman.class));
    }

    public List<Person> getCoachByName(String fullName) {
        String sql = "SELECT * FROM coach WHERE FULL_NAME = ?";
        return template.query(sql, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Coach> getCoachById(int id) {
        String sql = "SELECT s.ID, s.FULL_NAME, s.YOB, s.SPORTSCHOOL_ID, ss.NAME AS SPORTSCHOOL_NAME " +
                "FROM coach s " +
                "JOIN sports_school ss ON s.SPORTSCHOOL_ID = ss.ID " +
                "WHERE s.ID = ?";

        return template.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Coach.class));
    }

    public List<Competition> getAllCompetitions() {
        String sql = "SELECT c.ID, c.NAME, p.NAME AS POOL_NAME, c.START_DATE, c.END_DATE, c.DISTANCE FROM COMPETITION c JOIN POOL p ON c.POOL_ID = p.ID";
        return template.query(sql, new BeanPropertyRowMapper<>(Competition.class));
    }

    public List<Sportschool> getSchoolByName(String name) {
        String sql = "SELECT s.ID, s.NAME, p.POOL_SIZE " +
                "FROM SPORTS_SCHOOL s " +
                "JOIN POOL p ON s.POOL_ID = p.ID " +
                "WHERE s.NAME = ?";;
        return template.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Sportschool.class));
    }

    public List<TrainingWithExercises> getExercisesByUserId(int userId) {
        String sql = "SELECT t.ID AS trainingId, t.COACH_ID AS coachId, t.SPORTSMAN_ID AS sportsmanId, " +
                "e.ID AS exerciseId, e.DESCRIPTION, e.COUNT, e.TRAINING_ID  " +
                "FROM TRAINING t " +
                "LEFT JOIN EXERCISE e ON t.ID = e.TRAINING_ID " +
                "WHERE t.SPORTSMAN_ID = ?";
        return template.queryForObject(sql, new Object[]{userId}, new TrainingWithExercisesRowMapper());
    }


}
