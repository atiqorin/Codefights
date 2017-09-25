/*Please add ; after each select statement*/
CREATE PROCEDURE expressionsVerification()
BEGIN
	SELECT id, a, b, operation, c FROM (
        SELECT id, a, b, operation, c, CASE 
        WHEN operation = '+' THEN a + b
        WHEN operation = '-' THEN a - b
        WHEN operation = '/' THEN a / b
        WHEN operation = '*' THEN a * b
        END AS res
        FROM expressions
    ) r
    WHERE r.res = c
    ORDER BY r.id;
END