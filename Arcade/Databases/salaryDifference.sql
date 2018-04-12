/*Please add ; after each select statement*/
CREATE PROCEDURE salaryDifference()
BEGIN
    SELECT IF(COUNT(*) != 0,(mx.salary * mx.cnt - mn.salary*mn.cnt), 0) AS difference FROM
    (
        SELECT salary, COUNT(salary) AS cnt FROM employees
        GROUP BY salary
        ORDER BY salary DESC
        LIMIT 1
    ) AS mx, 
    (
        SELECT salary, COUNT(salary) AS cnt FROM employees
        GROUP BY salary
        ORDER BY salary
        LIMIT 1
    ) AS mn;
END