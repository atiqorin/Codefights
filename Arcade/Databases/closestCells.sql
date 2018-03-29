/*Please add ; after each select statement*/
CREATE PROCEDURE closestCells()
BEGIN
	SELECT t1.id1, t1.id2 FROM
    (
        SELECT p1.id AS id1, p2.id AS id2, (POWER(p1.x-p2.x, 2) + POWER(p1.y-p2.y, 2)) AS distance
        FROM positions p1
        JOIN positions p2
        ON p1.id != p2.id
    ) AS t1
    LEFT JOIN
    (
        SELECT p1.id AS id1, p2.id AS id2, (POWER(p1.x-p2.x, 2) + POWER(p1.y-p2.y, 2)) AS distance
        FROM positions p1
        JOIN positions p2
        ON p1.id != p2.id
    ) AS t2
    ON t1.id1 = t2.id1 AND t1.distance > t2.distance
    WHERE t2.distance IS NULL
    ORDER BY t1.id1;
END