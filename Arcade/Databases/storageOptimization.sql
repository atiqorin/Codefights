/*Please add ; after each select statement*/
CREATE PROCEDURE storageOptimization()
BEGIN
	SELECT c.id, c.column_name, c.value
    FROM(
        SELECT n.id AS id, 'name' AS column_name, n.name AS value
        FROM workers_info AS n
        WHERE n.name != ''
        UNION ALL
        SELECT b.id AS id, 'date_of_birth' AS column_name, b.date_of_birth AS value
        FROM workers_info AS b
        WHERE b.date_of_birth != ''
        UNION ALL
        SELECT s.id AS id, 'salary' AS column_name, s.salary AS value
        FROM workers_info AS s
        WHERE s.salary != ''
    ) AS c
    ORDER BY c.id, FIELD(c.column_name, 'name', 'date_of_birth', 'salary');
END