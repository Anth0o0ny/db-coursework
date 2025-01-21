package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.dto.entitiesDto.CompetitionDto;
import com.anth0o0ny.backend.dto.mapper.CompetitionMapper;
import com.anth0o0ny.backend.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    private final DB db;

    @Autowired
    public CompetitionService(DB db) {
        this.db = db;
    }

    public List<CompetitionDto> getAllCompetitions() {
        List<Competition> competitions = db.getAllCompetitions();
        return competitions.stream()
                .map(CompetitionMapper::toDto)
                .collect(Collectors.toList());
    }
}
