package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.enums.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getUserInfo(String userId) {
        String sql = Constants.SELECT_SPORTSMAN_BY_ID;
        List<Sportsman> sportsmen = jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) ->
                new Sportsman(
                        rs.getInt(Constants.ID),
                        rs.getString(Constants.COL_FULL_NAME),
                        rs.getDate(Constants.COL_YOB),
                        Rank.valueOf(rs.getString(Constants.COL_RANK)),
                        rs.getInt(Constants.COL_SCHOOL_ID)
                )
        );
        Sportsman sportsman = sportsmen.get(0);
        return Constants.OUTPUT_NAME_STRING + sportsman.getFullName() + Constants.OUTPUT_RANK_STRING + sportsman.getRank();
    }
}
