/*Please add ; after each select statement*/
CREATE PROCEDURE orderOfSuccession()
BEGIN
	SELECT 
        CASE WHEN (gender='M') THEN CONCAT('King ',name) 
        WHEN (gender='F') THEN CONCAT("Queen ", name) END
        AS name
    FROM Successors 
    ORDER BY birthday ASC;
END