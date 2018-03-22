/*Please add ; after each select statement*/
CREATE PROCEDURE netIncome()
BEGIN
	SELECT YEAR(date) AS year, QUARTER(date) AS quarter, SUM(profit) - SUM(loss) as net_profit
    FROM accounting
    GROUP BY YEAR(date), QUARTER(date)
    ORDER BY YEAR(date), QUARTER(date);
END