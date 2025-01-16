package com.anth0o0ny.backend;

public class Constants {
    // Config
    public static final String ALL_PATHS = "/**";
    public static final String ALL_HTTP_METHODS = "*";

    // Path variable
    public static final String FULL_NAME = "fullName";
    public static final String ID = "id";
    public static final String USER_ID = "userId";

    // Mapping
    public static final String COMPETITIONS = "/competitions";
    public static final String PERSONS_PATH = "/persons";
    public static final String SPORTS_MAN_PATH = "/sportsman";
    public static final String COACH_PATH = "/coach";
    public static final String SPORTS_MAN_NAME_PATH = SPORTS_MAN_PATH + "/name/{" + FULL_NAME + "}";
    public static final String SPORTS_MAN_ID_PATH = SPORTS_MAN_PATH + "/id/{" + ID + "}";
    public static final String COACH_NAME_PATH = COACH_PATH + "/name/{" + FULL_NAME + "}";
    public static final String COACH_ID_PATH = COACH_PATH + "/id/{" + ID + "}";
    public static final String PROFILES_PATH = "/profiles";
    public static final String PROFILE_PATH = PROFILES_PATH + "/{" + USER_ID + "}";
    public static final String TRAININGS_PATH = "/trainings";
    public static final String EXERCISES_PATH = "/exercises";
    public static final String TRAINING_EXERCISES_PATH = TRAININGS_PATH + "/{" + USER_ID + "}" + EXERCISES_PATH;
    public static final String SPORTS_SCHOOLS_PATH = "/sportschools";
    public static final String SPORTS_SCHOOLS_NAME_PATH = "name";
    public static final String CREATE_PATH = "/create";

    // Validation
    public static final String SUCCESS_TRAINING_CREATION = "Тренировка успешно создана.";
    public static final String ERROR_TRAINING_CREATION = "Ошибка при создании тренировки.";


    public static final String DATA_PATTERN = "yyyy-MM-dd";
    public static final String UTC_TIME_ZONE = "UTC";

    // Column labels for mapper
    public static final String TRAINING_ID = "trainingId";
    public static final String COACH_ID = "coachId";
    public static final String SPORTSMAN_ID = "sportsmanId";
    public static final String EXERCISE_ID = "exerciseId";
    public static final String DESCRIPTION = "description";
    public static final String COUNT = "count";

    // Service constants
    public static final String INSERT_EXERCISE = "INSERT INTO EXERCISE (DESCRIPTION, COUNT, TRAINING_ID) VALUES (?, ?, ?)";

    // Названия колонок
    public static final String COL_FULL_NAME = "full_name";
    public static final String COL_YOB = "yob";
    public static final String COL_RANK = "rank";
    public static final String COL_SCHOOL_ID = "sportschool_id";

    // For output
    public static final String OUTPUT_NAME_STRING = "Имя: ";
    public static final String OUTPUT_RANK_STRING = ", Разряд: ";

    // Path to sql file
    public static final String MAIN_SQL_CREATE_PATH = "src/main/resources/sql/create/";
    public static final String INIT_FILE_NAME_MODEL = "model";

    // SQL scripts
    public static final String GET_SPORTSMAN_BY_NAME = "SELECT * FROM sportsman WHERE FULL_NAME = ?";
    public static final String GET_SPORTSMAN_BY_ID = "SELECT s.ID, s.FULL_NAME, s.YOB, s.RANK, ss.NAME AS SPORTSCHOOL_NAME " +
            "FROM sportsman s " +
            "JOIN sports_school ss ON s.SPORTSCHOOL_ID = ss.ID " +
            "WHERE s.ID = ?";
    public static final String GET_COACH_BY_NAME = "SELECT * FROM coach WHERE FULL_NAME = ?";
    public static final String GET_COACH_BY_ID = "SELECT s.ID, s.FULL_NAME, s.YOB, s.SPORTSCHOOL_ID, ss.NAME AS SPORTSCHOOL_NAME " +
            "FROM coach s " +
            "JOIN sports_school ss ON s.SPORTSCHOOL_ID = ss.ID " +
            "WHERE s.ID = ?";
    public static final String GET_ALL_COMPETITIONS = "SELECT c.ID, c.NAME, p.NAME AS POOL_NAME, c.START_DATE, c.END_DATE, c.DISTANCE FROM COMPETITION c JOIN POOL p ON c.POOL_ID = p.ID";
    public static final String GET_SCHOOL_BY_NAME = "SELECT s.ID, s.NAME, p.POOL_SIZE " +
            "FROM SPORTS_SCHOOL s " +
            "JOIN POOL p ON s.POOL_ID = p.ID " +
            "WHERE s.NAME = ?";
    public static final String GET_EXERCISES_BY_USER_ID = "SELECT t.ID AS trainingId, t.COACH_ID AS coachId, t.SPORTSMAN_ID AS sportsmanId, " +
            "e.ID AS exerciseId, e.DESCRIPTION, e.COUNT, e.TRAINING_ID  " +
            "FROM TRAINING t " +
            "LEFT JOIN EXERCISE e ON t.ID = e.TRAINING_ID " +
            "WHERE t.SPORTSMAN_ID = ?";
    public static final String SELECT_SPORTSMAN_BY_NAME = "SELECT * FROM SPORTSMAN WHERE FULL_NAME = ?";
    public static final String SELECT_SPORTSMAN_BY_ID = "SELECT * FROM SPORTSMAN WHERE ID = ?";
    public static final String SELECT_COACH_BY_NAME = "SELECT * FROM COACH WHERE FULL_NAME = ?";
    public static final String SELECT_COACH_BY_ID = "SELECT * FROM COACH WHERE ID = ?";
    public static final String SELECT_LAST_TRAINING_ID = "SELECT MAX(ID) FROM TRAINING";
    public static final String INSERT_TRAINING = "INSERT INTO TRAINING (COACH_ID, SPORTSMAN_ID) VALUES (?, ?)";
}
