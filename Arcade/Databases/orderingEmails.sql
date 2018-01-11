/*Please add ; after each select statement*/
CREATE PROCEDURE orderingEmails()
BEGIN
	SELECT id, email_title, IF(
        size < POWER(2,20),
        CONCAT(FLOOR(size/POWER(2,10))," Kb"),
        CONCAT(FLOOR(size/POWER(2,20))," Mb")) AS short_size
    FROM emails
    ORDER BY size DESC;
END