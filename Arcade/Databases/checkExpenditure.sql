/*Please add ; after each select statement*/
CREATE PROCEDURE checkExpenditure()
BEGIN
	SELECT id, IF(loss < 0, 0, loss) AS loss FROM 
        (SELECT id, (
            (SELECT SUM(expenditure_sum)
            FROM expenditure_plan
            WHERE (WEEK(monday_date) BETWEEN left_bound AND right_bound)
            ) - value) AS loss
        FROM allowable_expenditure) AS r;
     
END