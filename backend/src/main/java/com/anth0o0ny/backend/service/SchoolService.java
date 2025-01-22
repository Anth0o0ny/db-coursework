package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.dto.entitiesDto.SportschoolDto;
import com.anth0o0ny.backend.dto.mapper.SportschoolMapper;
import com.anth0o0ny.backend.entities.Sportschool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final DB db;
    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    public SchoolService(DB db) {
        this.db = db;
    }

    public List<SportschoolDto> getSchoolByName(String name) {
        try {
            List<Sportschool> schools = db.getSchoolByName(name);

            if (schools.isEmpty()) {
                logger.warn(Constants.WARNING_NO_SPORTSCHOOL_FOUND_BY_NAME, name);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_SPORTSCHOOL_FOUND_BY_NAME);
            }
            return schools.stream()
                    .map(SportschoolMapper::toDto)
                    .collect(Collectors.toList());
        } catch (ResponseStatusException e) {
            logger.error(Constants.ERROR_FETCHING_SPORTSCHOOLS_BY_NAME, name, e);
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_SPORTSCHOOLS_BY_NAME, name, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FETCHING_SPORTSCHOOLS);
        }
    }
}
