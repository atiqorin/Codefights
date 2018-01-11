/*Please add ; after each select statement*/
CREATE PROCEDURE newsSubscribers()
BEGIN
	SELECT distinct subscriber 
    FROM full_year
    where newspaper LIKE '%Daily%'
    union 
    SELECT distinct subscriber 
    FROM half_year
    where newspaper LIKE '%Daily%'
    order by subscriber;
END