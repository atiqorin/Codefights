/*Please add ; after each select statement*/
CREATE PROCEDURE marketReport()
BEGIN
    SELECT IFNULL(country, 'Total:') AS country,
    COUNT(country) AS competitors
    FROM foreignCompetitors
    GROUP BY country WITH ROLLUP;
END