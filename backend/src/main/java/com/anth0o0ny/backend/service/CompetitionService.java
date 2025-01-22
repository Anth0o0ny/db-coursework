package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.dto.entitiesDto.CompetitionDto;
import com.anth0o0ny.backend.dto.mapper.CompetitionMapper;
import com.anth0o0ny.backend.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CompetitionService {

    private final DB db;
    private static final Logger logger = LoggerFactory.getLogger(CompetitionService.class);

    @Autowired
    public CompetitionService(DB db) {
        this.db = db;
    }

    public List<CompetitionDto> getAllCompetitions() {
        try {
            List<Competition> competitions = db.getAllCompetitions();
            if (competitions == null || competitions.isEmpty()) {
                logger.warn(Constants.WARNING_NO_COMPETITIONS_FOUND);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_COMPETITIONS_NOT_FOUND);
            }
            return competitions.stream()
                    .map(CompetitionMapper::toDto)
                    .collect(Collectors.toList());
        } catch (ResponseStatusException e) {
            logger.error(Constants.ERROR_FETCH_COMPETITIONS, e);
            throw e;
        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCH_COMPETITIONS, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_PROCESSING_REQUEST);
        }
    }

}
