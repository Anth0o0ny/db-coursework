CREATE OR REPLACE FUNCTION get_competition_distants(RESULT_ID INTEGER) RETURNS DISTANCE AS
$$
BEGIN
SELECT DISTANCE FROM COMPETITION WHERE RESULT_ID=COMPETITION_ID;
END
$$
LANGUAGE "plpgsql";