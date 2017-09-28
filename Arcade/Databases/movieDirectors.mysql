/*Please add ; after each select statement*/
CREATE PROCEDURE movieDirectors()
BEGIN
    SELECT DISTINCT director
    FROM(
        SELECT director, SUM(oscars) as oscars 
        FROM moviesInfo
        WHERE year > 2000
        GROUP BY director
    ) r WHERE r.oscars > 2
    ORDER BY director;
END