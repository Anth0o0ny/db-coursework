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

    // Column names
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

    // Logger Messages
    public static final String LOG_GET_ALL_COMPETITIONS = "Received request to get all competitions";
    public static final String LOG_GET_EXERCISES_BY_USER_ID = "Received request to get exercises for userId: {}";
    public static final String LOG_GET_SPORTSMAN_BY_NAME = "Received request to get sportsman by name: {}";
    public static final String LOG_GET_SPORTSMAN_BY_ID = "Received request to get sportsman by ID: {}";
    public static final String LOG_GET_COACH_BY_NAME = "Received request to get coach by name: {}";
    public static final String LOG_GET_COACH_BY_ID = "Received request to get coach by ID: {}";
    public static final String LOG_GET_PROFILE_INFO = "Received request to get profile info for userId: {}";
    public static final String LOG_GET_SCHOOL_BY_NAME = "Received request to get school by name: {}";
    public static final String LOG_RECEIVED_CREATE_TRAINING = "Received request to create training: {}";
    public static final String LOG_TRAINING_CREATED_SUCCESSFULLY = "Training created successfully with ID: {}";
    public static final String LOG_ERROR_CREATING_TRAINING = "Error occurred while creating training";
    public static final String WARNING_NO_COMPETITIONS_FOUND = "No competitions found.";
    public static final String ERROR_COMPETITIONS_NOT_FOUND = "Competitions not found.";
    public static final String ERROR_FETCH_COMPETITIONS = "Error occurred while fetching competitions";
    public static final String ERROR_PROCESSING_REQUEST = "An error occurred while processing request.";
    public static final String WARNING_NO_EXERCISES_FOUND_FOR_USER = "No exercises found for userId: {}";
    public static final String ERROR_NO_EXERCISES_FOR_USER = "No exercises found for the given user.";
    public static final String ERROR_FETCHING_EXERCISES = "Error occurred while fetching exercises for userId: {}";
    public static final String WARNING_EMPTY_EXERCISE_DESCRIPTION = "Attempt to add exercise with empty description for trainingId: {}";
    public static final String ERROR_EMPTY_DESCRIPTION = "Exercise description cannot be empty.";
    public static final String WARNING_INVALID_EXERCISE_COUNT = "Attempt to add exercise with invalid count (<= 0) for trainingId: {}";
    public static final String ERROR_INVALID_EXERCISE_COUNT = "Exercise count must be greater than zero.";
    public static final String ERROR_ADDING_EXERCISE = "Error occurred while adding exercise for trainingId: {}";
    public static final String WARNING_NO_SPORTSMAN_FOUND_BY_NAME = "No sportsman found with full name: {}";
    public static final String ERROR_NO_SPORTSMAN_FOUND_BY_NAME = "No sportsman found with the given name.";
    public static final String ERROR_FETCHING_SPORTSMAN_BY_NAME = "Error occurred while fetching sportsman by name: {}";
    public static final String ERROR_FETCHING_SPORTSMAN_DATA = "An error occurred while fetching sportsman data.";
    public static final String WARNING_NO_SPORTSMAN_FOUND_BY_ID = "No sportsman found with id: {}";
    public static final String ERROR_NO_SPORTSMAN_FOUND_BY_ID = "No sportsman found with the given ID.";
    public static final String ERROR_FETCHING_SPORTSMAN_BY_ID = "Error occurred while fetching sportsman by id: {}";
    public static final String WARNING_NO_COACH_FOUND_BY_NAME = "No coach found with full name: {}";
    public static final String ERROR_NO_COACH_FOUND_BY_NAME = "No coach found with the given name.";
    public static final String ERROR_FETCHING_COACH_BY_NAME = "Error occurred while fetching coach by name: {}";
    public static final String WARNING_NO_COACH_FOUND_BY_ID = "No coach found with id: {}";
    public static final String ERROR_NO_COACH_FOUND_BY_ID = "No coach found with the given ID.";
    public static final String ERROR_FETCHING_COACH_BY_ID = "Error occurred while fetching coach by id: {}";
    public static final String ERROR_FETCHING_COACH_DATA = "An error occurred while fetching coach data.";
    public static final String ERROR_INVALID_USER_ID_FORMAT = "Invalid user ID format: {}";
    public static final String ERROR_INVALID_USER_ID_FORMAT_MESSAGE = "Invalid user ID format.";
    public static final String ERROR_FETCHING_USER_INFO = "Error occurred while fetching user info for user ID: {}";
    public static final String ERROR_FETCHING_USER_INFO_MESSAGE = "An error occurred while fetching user info.";
    public static final String WARNING_NO_SPORTSCHOOL_FOUND_BY_NAME = "No sportschool found with name: {}";
    public static final String ERROR_NO_SPORTSCHOOL_FOUND_BY_NAME = "No sportschool found with the given name.";
    public static final String ERROR_FETCHING_SPORTSCHOOLS_BY_NAME = "Error occurred while fetching sportschools with name: {}";
    public static final String ERROR_FETCHING_SPORTSCHOOLS = "An error occurred while fetching sportschools.";
    public static final String WARNING_FAILED_TO_RETRIEVE_LAST_TRAINING_ID = "Failed to retrieve the last training ID after creating training for coachId: {} and sportsmanId: {}";
    public static final String ERROR_FAILED_TO_RETRIEVE_LAST_TRAINING_ID = "Failed to retrieve the last training ID.";
    public static final String ERROR_CREATING_TRAINING = "Error occurred while creating training for coachId: {} and sportsmanId: {}";

    // Validation error messages
    public static final String ERROR_YOB_PAST = "Year of birth must be a past date";
    public static final String ERROR_SCHOOL_ID_NULL = "Sportschool ID cannot be null";
    public static final String ERROR_COMPETITION_NAME_SIZE = "Competition name must be between 3 and 100 characters";
    public static final String ERROR_POOL_NAME_NULL = "Pool name cannot be null";
    public static final String ERROR_DISTANCE_NULL = "Distance cannot be null";
    public static final String ERROR_DESCRIPTION_NULL = "Description cannot be null";
    public static final String ERROR_DESCRIPTION_SIZE = "Description must be between 3 and 255 characters";
    public static final String ERROR_COUNT_NULL = "Count cannot be null";
    public static final String ERROR_FULL_NAME_NULL = "Full name cannot be null";
    public static final String ERROR_FULL_NAME_SIZE = "Full name must be between 3 and 100 characters";
    public static final String ERROR_POOL_NAME_SIZE = "Pool name must be between 3 and 100 characters";
    public static final String ERROR_LOCATION_NULL = "Location cannot be null";
    public static final String ERROR_LOCATION_SIZE = "Location must be between 3 and 100 characters";
    public static final String ERROR_SCHOOL_NAME_NULL = "School name cannot be null";
    public static final String ERROR_SCHOOL_NAME_SIZE = "School name must be between 3 and 100 characters";
    public static final String ERROR_YOB_PAST_DATE = "Year of birth must be a past date";
    public static final String ERROR_RANK_NULL = "Rank cannot be null";
    public static final String ERROR_SPORTSCHOOL_ID_NULL = "Sportschool ID cannot be null";
    public static final String ERROR_COACH_ID_NULL = "Coach ID cannot be null";
    public static final String ERROR_SPORTSMAN_ID_NULL = "Sportsman ID cannot be null";
    public static final String ERROR_EXERCISES_NULL = "Exercises cannot be null";
}
