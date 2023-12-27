package com.anth0o0ny.backend.database;

import com.anth0o0ny.backend.entities.Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DB {

    @Autowired
    JdbcTemplate template;

    public DB() {
    }

    public boolean addPool(Pool pool) {
        String sql = "INSERT INTO pool (id, name, pool_size) VALUES (?, ?, ?)";
        template.update(
                sql,
                pool.getId(),
                pool.getName(),
                pool.getPoolSize()
        );
        return true;
    }
}
