/*Please add ; after each select statement*/
CREATE PROCEDURE placesOfInterestPairs()
BEGIN
	SELECT s1.name AS place1, s2.name AS place2
    FROM sights AS s1
    JOIN sights AS s2
    WHERE POWER(s1.x - s2.x, 2) - POWER(s1.y - s2.y, 2) != 0
        AND POWER(s1.x - s2.x, 2) + POWER(s1.y - s2.y, 2) < 25
        AND s1.name < s2.name
    ORDER BY s1.name, s2.name;
END