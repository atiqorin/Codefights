/*Please add ; after each select statement*/
CREATE PROCEDURE consecutiveIds()
BEGIN
	SELECT a.id AS oldId, COUNT(a.id) AS newId
    FROM itemIds AS a
    JOIN itemIds AS b ON a.id >= b.id
    GROUP BY a.id
    ORDER BY a.id;
END