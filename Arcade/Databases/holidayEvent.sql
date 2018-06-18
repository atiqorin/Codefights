/*Please add ; after each select statement*/
CREATE PROCEDURE holidayEvent()
BEGIN
    SET @i = 0;
	SELECT DISTINCT buyer_name AS winners
    FROM(
        SELECT buyer_name, @i := @i + 1 AS num
        FROM purchases
    ) AS dummy
    WHERE num % 4 = 0
    ORDER BY winners;
END