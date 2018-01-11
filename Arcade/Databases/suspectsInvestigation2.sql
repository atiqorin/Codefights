/*Please add ; after each select statement*/
CREATE PROCEDURE suspectsInvestigation2()
BEGIN
	SELECT id, name, surname
    FROM Suspect
    WHERE name NOT LIKE 'B%'
    OR surname NOT LIKE 'Gre_n'
    OR height <= 170;
END