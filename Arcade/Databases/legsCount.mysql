DROP PROCEDURE IF EXISTS legsCount;
CREATE PROCEDURE legsCount()
    SELECT SUM(CASE WHEN type = 'human' THEN 2 WHEN type = 'cat' THEN 4 WHEN type = 'dog' THEN 4 ELSE 0 END) as summary_legs
    FROM creatures
    ORDER BY id;
