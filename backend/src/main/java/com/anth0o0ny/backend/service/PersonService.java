package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.CoachDto;
import com.anth0o0ny.backend.dto.entitiesDto.PersonDto;
import com.anth0o0ny.backend.dto.entitiesDto.SportsmanDto;
import com.anth0o0ny.backend.dto.mapper.PersonMapper;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.enums.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public PersonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PersonDto> getSportsmanByName(String fullName) {
        try {
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

            if (sportsmen.isEmpty()) {
                logger.warn(Constants.WARNING_NO_SPORTSMAN_FOUND_BY_NAME, fullName);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_SPORTSMAN_FOUND_BY_NAME);
            }

            return sportsmen.stream()
                    .map(PersonMapper::toDto)
                    .collect(Collectors.toList());

        } catch (ResponseStatusException e) {
            logger.error(Constants.ERROR_FETCHING_SPORTSMAN_BY_NAME, fullName, e);
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_SPORTSMAN_BY_NAME, fullName, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FETCHING_SPORTSMAN_DATA);
        }
    }

    public List<SportsmanDto> getSportsmanById(int id) {
        try {
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

            if (sportsmen.isEmpty()) {
                logger.warn(Constants.WARNING_NO_SPORTSMAN_FOUND_BY_ID, id);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_SPORTSMAN_FOUND_BY_ID);
            }

            return sportsmen.stream()
                    .map(PersonMapper::toDto)
                    .collect(Collectors.toList());

        } catch (ResponseStatusException e) {
            logger.error(Constants.ERROR_FETCHING_SPORTSMAN_BY_ID, id, e);
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_SPORTSMAN_BY_ID, id, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FETCHING_SPORTSMAN_DATA);
        }
    }

    public List<PersonDto> getCoachByName(String fullName) {
        try {
            String sql = Constants.SELECT_COACH_BY_NAME;
            List<Coach> coaches = jdbcTemplate.query(sql, new Object[]{fullName}, (rs, rowNum) ->
                    new Coach(
                            rs.getInt(Constants.ID),
                            rs.getString(Constants.COL_FULL_NAME),
                            rs.getDate(Constants.COL_YOB),
                            rs.getInt(Constants.COL_SCHOOL_ID)
                    )
            );

            if (coaches.isEmpty()) {
                logger.warn(Constants.WARNING_NO_COACH_FOUND_BY_NAME, fullName);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_COACH_FOUND_BY_NAME);
            }

            return coaches.stream()
                    .map(PersonMapper::toDto)
                    .collect(Collectors.toList());

        } catch (ResponseStatusException e) {
            logger.error(Constants.ERROR_FETCHING_COACH_BY_NAME, fullName, e);
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_COACH_BY_NAME, fullName, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FETCHING_COACH_DATA);
        }
    }

    public List<CoachDto> getCoachById(int id) {
        try {
            String sql = Constants.SELECT_COACH_BY_ID;
            List<Coach> coaches = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) ->
                    new Coach(
                            rs.getInt(Constants.ID),
                            rs.getString(Constants.COL_FULL_NAME),
                            rs.getDate(Constants.COL_YOB),
                            rs.getInt(Constants.COL_SCHOOL_ID)
                    )
            );

            if (coaches.isEmpty()) {
                logger.warn(Constants.WARNING_NO_COACH_FOUND_BY_ID, id);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_COACH_FOUND_BY_ID);
            }

            return coaches.stream()
                    .map(PersonMapper::toDto)
                    .collect(Collectors.toList());

        } catch (ResponseStatusException e) {
            logger.error(Constants.ERROR_FETCHING_COACH_BY_ID, id, e);
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_COACH_BY_ID, id, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FETCHING_COACH_DATA);
        }
    }
}
