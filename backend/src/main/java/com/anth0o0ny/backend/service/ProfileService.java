package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.enums.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProfileService {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    public ProfileService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getUserInfo(String userId) {
        try {
            int userIdInt;
            try {
                userIdInt = Integer.parseInt(userId);
            } catch (NumberFormatException e) {
                logger.error(Constants.ERROR_INVALID_USER_ID_FORMAT, userId, e);
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.ERROR_INVALID_USER_ID_FORMAT_MESSAGE);
            }

            String sql = Constants.SELECT_SPORTSMAN_BY_ID;
            List<Sportsman> sportsmen = jdbcTemplate.query(sql, new Object[]{userIdInt}, (rs, rowNum) ->
                    new Sportsman(
                            rs.getInt(Constants.ID),
                            rs.getString(Constants.COL_FULL_NAME),
                            rs.getDate(Constants.COL_YOB),
                            Rank.valueOf(rs.getString(Constants.COL_RANK)),
                            rs.getInt(Constants.COL_SCHOOL_ID)
                    )
            );

            if (sportsmen.isEmpty()) {
                logger.warn(Constants.WARNING_NO_SPORTSMAN_FOUND_BY_ID, userIdInt);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERROR_NO_SPORTSMAN_FOUND_BY_ID);
            }

            Sportsman sportsman = sportsmen.get(0);
            return Constants.OUTPUT_NAME_STRING + sportsman.getFullName() + Constants.OUTPUT_RANK_STRING + sportsman.getRank();

        } catch (Exception e) {
            logger.error(Constants.ERROR_FETCHING_USER_INFO, userId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ERROR_FETCHING_USER_INFO_MESSAGE);
        }
    }
}
