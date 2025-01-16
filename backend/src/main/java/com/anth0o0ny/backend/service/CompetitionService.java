package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private final DB db;

    @Autowired
    public CompetitionService(DB db) {
        this.db = db;
    }

    public List<Competition> getAllCompetitions() {
        return db.getAllCompetitions();
    }
}
