/*Please add ; after each select statement*/
CREATE PROCEDURE alarmClocks()
BEGIN
	DROP TABLE IF EXISTS alarm_list;
    CREATE TABLE IF NOT EXISTS alarm_list(alarm_date DATETIME);
    SET @date := (SELECT input_date FROM userInput);
    SET @year := (SELECT YEAR(input_date) FROM userInput);
    
    WHILE YEAR(@date) = @year DO
        INSERT INTO alarm_list(alarm_date) SELECT @date;
        SET @date := @date + INTERVAL 7 DAY;
    END WHILE;
    SELECT * FROM alarm_list;
END