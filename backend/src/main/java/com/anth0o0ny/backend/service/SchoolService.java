package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Sportschool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final DB db;

    @Autowired
    public SchoolService(DB db) {
        this.db = db;
    }

    public List<Sportschool> getSchoolByName(String name) {
        return db.getSchoolByName(name);
    }
}
