package com.anth0o0ny.backend.database;

import com.anth0o0ny.backend.entities.Person;
import com.anth0o0ny.backend.entities.Pool;
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
}
