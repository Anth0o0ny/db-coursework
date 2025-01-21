package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.CoachDto;
import com.anth0o0ny.backend.dto.entitiesDto.PersonDto;
import com.anth0o0ny.backend.dto.entitiesDto.SportsmanDto;
import com.anth0o0ny.backend.dto.mapper.PersonMapper;
import com.anth0o0ny.backend.entities.Person;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.enums.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PersonDto> getSportsmanByName(String fullName) {
        String sql = Constants.SELECT_SPORTSMAN_BY_NAME;
        List<Sportsman> sportsmen = jdbcTemplate.query(sql, new Object[]{fullName}, (rs, rowNum) ->
                new Sportsman(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        Rank.valueOf(rs.getString(Constants.COL_RANK)),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
        return sportsmen.stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<SportsmanDto> getSportsmanById(int id) {
        String sql = Constants.SELECT_SPORTSMAN_BY_ID;
        List<Sportsman> sportsmen = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) ->
                new Sportsman(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        Rank.valueOf(rs.getString(Constants.COL_RANK)),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
        return sportsmen.stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getCoachByName(String fullName) {
        String sql = Constants.SELECT_COACH_BY_NAME;
        List<Coach> coaches = jdbcTemplate.query(sql, new Object[]{fullName}, (rs, rowNum) ->
                new Coach(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
        return coaches.stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CoachDto> getCoachById(int id) {
        String sql = Constants.SELECT_COACH_BY_ID;
        List<Coach> coaches = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) ->
                new Coach(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
        return coaches.stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }
}
