/*Please add ; after each select statement*/
CREATE PROCEDURE gradeDistribution()
BEGIN
	SELECT Name, ID FROM Grades
    WHERE Final > (Midterm1/4 + Midterm2/4+Final/2)
    ANd Final > (Midterm1/2 + Midterm2/2)
    ORDER BY LEFT(Name, 3), ID;
END