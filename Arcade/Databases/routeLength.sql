/*Please add ; after each select statement*/
CREATE PROCEDURE routeLength()
BEGIN
	SET @id := 1;
    SET @len := (SELECT COUNT(*) FROM cities);
    SET @x1 := 0;
    SET @x2 := 0;
    SET @y1 := 0;
    SET @y2 := 0;
    SET @res := 0;

    WHILE @id < @len DO
        SET @x1 := (SELECT x FROM cities WHERE id = @id);
        SET @y1 := (SELECT y FROM cities WHERE id = @id);
        SET @x2 := (SELECT x FROM cities WHERE id = @id + 1);
        SET @y2 := (SELECT y FROM cities WHERE id = @id + 1);
        SET @res := @res + SQRT(POWER((@x1 - @x2), 2) + (POWER((@y1 - @y2), 2)));
        SET @id := @id + 1;
    END WHILE;
    
    SELECT ROUND(@res, 9) AS total;
END