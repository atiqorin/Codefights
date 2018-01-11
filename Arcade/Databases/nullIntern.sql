/*Please add ; after each select statement*/
CREATE PROCEDURE nullIntern()
BEGIN
	SELECT COUNT(*) AS number_of_nulls
    FROM departments
    WHERE description IS NULL
    OR UPPER(description) REGEXP '^[[:blank:]]*(NULL|NIL|\-)[[:blank:]]*$';
END