/*Please add ; after each select statement*/
CREATE PROCEDURE projectsTeam()
BEGIN
	SELECT DISTINCT name from projectLog ORDER BY name;
END