package com.anth0o0ny.backend.controllers;


import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Sportschool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sportschool")
public class SchoolController {

    @Autowired
    private DB db;

    @PostMapping("/getSchoolByName")
    public List<Sportschool> getSchoolByName(@RequestBody Map<String, String> requestBody){
        String name = requestBody.get("name");
        return db.getSchoolByName(name);
    }
}
