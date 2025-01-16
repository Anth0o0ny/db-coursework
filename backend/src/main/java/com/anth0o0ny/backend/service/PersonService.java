package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.Person;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.enums.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getSportsmanByName(String fullName) {
        String sql = Constants.SELECT_SPORTSMAN_BY_NAME;
        return jdbcTemplate.query(sql, new Object[]{fullName}, (rs, rowNum) ->
                new Sportsman(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        Rank.valueOf(rs.getString(Constants.COL_RANK)),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
    }

    public List<Sportsman> getSportsmanById(int id) {
        String sql = Constants.SELECT_SPORTSMAN_BY_ID;
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) ->
                new Sportsman(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        Rank.valueOf(rs.getString(Constants.COL_RANK)),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
    }

    public List<Person> getCoachByName(String fullName) {
        String sql = Constants.SELECT_COACH_BY_NAME;
        return jdbcTemplate.query(sql, new Object[]{fullName}, (rs, rowNum) ->
                new Coach(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
    }


    public List<Coach> getCoachById(int id) {
        String sql = Constants.SELECT_COACH_BY_ID;
        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) ->
                new Coach(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
    }

}
