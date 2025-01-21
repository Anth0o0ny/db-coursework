package com.anth0o0ny.backend.database;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.anth0o0ny.backend.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String mainPath = Constants.MAIN_SQL_CREATE_PATH;
    private final String[] initFileNames = {Constants.INIT_FILE_NAME_MODEL};

    @Override
    public void run(String... args) throws Exception {
        String query;

        for (int i = 0; i < initFileNames.length; i++) {
            try {
                query = new String(Files.readAllBytes(Paths.get(mainPath + initFileNames[i] + ".sql")));
                jdbcTemplate.execute(query);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
