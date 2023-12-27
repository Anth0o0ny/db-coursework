package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private DB db;

    public MainController() { }

    @GetMapping("ready")
    public String getName() {
        return "ready";
    }


    @PostMapping("add")
    public Optional<Pool> addPool(@RequestBody Pool pool) {
        System.out.println(pool);
        db.addPool(pool);
        return Optional.of(pool);
    }

}