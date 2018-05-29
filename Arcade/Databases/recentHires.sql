/*Please add ; after each select statement*/
CREATE PROCEDURE recentHires()
BEGIN
    SELECT name AS names FROM
    (
        (SELECT id, name, 1 AS department FROM
            (SELECT id, name FROM pr_department
                ORDER BY date_joined DESC
                LIMIT 5)
            AS names_pr
        )
        UNION
        (SELECT id, name, 2 AS department FROM
            (SELECT id, name FROM it_department
                ORDER BY date_joined DESC
                LIMIT 5)
            AS names_it
        )
        UNION
        (SELECT id, name, 3 AS department FROM
            (SELECT id, name FROM sales_department
                ORDER BY date_joined DESC
                LIMIT 5)
            AS names_sales
        )
    ) AS names_outer
    ORDER BY department, names;
END