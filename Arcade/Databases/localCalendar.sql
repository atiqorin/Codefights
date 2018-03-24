/*Please add ; after each select statement*/
CREATE PROCEDURE localCalendar()
BEGIN
	SELECT e.event_id, 
    CASE 
        WHEN s.hours = '12'
            THEN DATE_FORMAT(DATE_ADD(date, INTERVAL timeshift MINUTE), '%Y-%m-%d %h:%i %p')
        ELSE
            DATE_FORMAT(DATE_ADD(date, INTERVAL timeshift MINUTE), '%Y-%m-%d %H:%i')
        END AS formatted_date
    FROM events e
    JOIN settings s
    ON e.user_id = s.user_id;
END