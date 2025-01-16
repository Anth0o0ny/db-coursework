package com.anth0o0ny.backend.database;

import com.anth0o0ny.backend.Constants;
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
        return template.query(Constants.GET_SPORTSMAN_BY_NAME, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Sportsman> getSportsmanById(int id) {
        return template.query(Constants.GET_SPORTSMAN_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Sportsman.class));
    }

    public List<Person> getCoachByName(String fullName) {
        return template.query(Constants.GET_COACH_BY_NAME, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Coach> getCoachById(int id) {
        return template.query(Constants.GET_COACH_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Coach.class));
    }

    public List<Competition> getAllCompetitions() {
        return template.query(Constants.GET_ALL_COMPETITIONS, new BeanPropertyRowMapper<>(Competition.class));
    }

    public List<Sportschool> getSchoolByName(String name) {
        return template.query(Constants.GET_SCHOOL_BY_NAME, new Object[]{name}, new BeanPropertyRowMapper<>(Sportschool.class));
    }

    public List<TrainingWithExercises> getExercisesByUserId(int userId) {
        return template.queryForObject(Constants.GET_EXERCISES_BY_USER_ID, new Object[]{userId}, new TrainingWithExercisesRowMapper());
    }
}
