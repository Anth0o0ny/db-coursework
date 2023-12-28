package com.anth0o0ny.backend.database;

import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.entities.Person;
import com.anth0o0ny.backend.entities.Pool;
import com.anth0o0ny.backend.entities.Sportsman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DB {

    @Autowired
    JdbcTemplate template;

    public DB() {
    }

    public boolean addPool(Pool pool) {
        String sql = "INSERT INTO pool (id, name, pool_size) VALUES (?, ?, ?::pool_size)";
        template.update(
                sql,
                pool.getId(),
                pool.getName(),
                pool.getPoolSize().toString()
        );
        return true;
    }

    public List<Person> getSportsmanByName(String fullName) {
        String sql = "SELECT * FROM sportsman WHERE FULL_NAME = ?";
        return template.query(sql, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Sportsman> getSportsmanById(int id) {
        String sql = "SELECT s.ID, s.FULL_NAME, s.YOB, s.RANK, s.SPORTSCHOOL_ID, ss.NAME AS SPORTSCHOOL_NAME " +
                "FROM sportsman s " +
                "JOIN sports_school ss ON s.SPORTSCHOOL_ID = ss.ID " +
                "WHERE s.ID = ?";

        return template.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Sportsman.class));
    }

    public List<Person> getCoachByName(String fullName) {
        String sql = "SELECT * FROM coach WHERE FULL_NAME = ?";
        return template.query(sql, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Coach> getCoachById(int id) {
        String sql = "SELECT s.ID, s.FULL_NAME, s.YOB, s.SPORTSCHOOL_ID, ss.NAME AS SPORTSCHOOL_NAME " +
                "FROM coach s " +
                "JOIN sports_school ss ON s.SPORTSCHOOL_ID = ss.ID " +
                "WHERE s.ID = ?";

        return template.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Coach.class));
    }
}
