/*Please add ; after each select statement*/
CREATE PROCEDURE soccerGameSeries()
BEGIN
	SELECT CASE 
      WHEN wins > 0 THEN 1
      WHEN wins < 0 THEN 2
      WHEN diff > 0 THEN 1
      WHEN diff < 0 THEN 2
      WHEN home > 0 THEN 1
      WHEN home < 0 THEN 2
      ELSE 0
   END winner
   FROM
   (
      SELECT 
         SUM(IF(s1 > s2, 1, -1)) AS wins,
         SUM(s1 - s2) AS diff,
         SUM(IF(h = 2, s1, -s2)) AS home
      FROM
      (
         SELECT first_team_score s1, second_team_score s2, match_host h 
         FROM scores
      ) AS x
   ) AS y;
END