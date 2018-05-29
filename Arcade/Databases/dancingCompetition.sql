/*Please add ; after each select statement*/
CREATE PROCEDURE dancingCompetition()
BEGIN
	SELECT scores.* FROM scores,
    (SELECT
        MIN(first_criterion) AS min1,
        MAX(first_criterion) AS max1,
        MIN(second_criterion) AS min2,
        MAX(second_criterion) AS max2,
        MIN(third_criterion) AS min3,
        MAX(third_criterion) AS max3
    FROM scores) AS extremes
    WHERE
        IF(first_criterion = min1 || first_criterion = max1,1,0) +
        IF(second_criterion= min2 || second_criterion = max2,1,0) +
        IF(third_criterion= min3 || third_criterion = max3,1,0) < 2;
END