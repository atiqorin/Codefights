/*Please add ; after each select statement*/
CREATE PROCEDURE trackingSystem()
BEGIN
    SELECT l.anonym_id, l.last_null AS last_null, r.first_notnull AS first_notnull
    FROM(
        SELECT ll.event_name AS last_null, ll.anonymous_id AS anonym_id, ll.received_at
        FROM tracks AS ll
        JOIN(
            SELECT anonymous_id, MAX(received_at) AS received_at
            FROM tracks
            WHERE user_id IS NULL
            GROUP BY anonymous_id
        ) lr
        ON ll.received_at = lr.received_at
    ) AS l
    LEFT JOIN(
        SELECT rl.event_name AS first_notnull, rl.anonymous_id AS anonym_id, rl.received_at
        FROM tracks AS rl
        JOIN(
            SELECT anonymous_id, MIN(received_at) AS received_at
            FROM tracks
            WHERE user_id IS NOT NULL
            GROUP BY anonymous_id
        ) rr
        ON rl.received_at = rr.received_at
    ) AS r
    ON l.anonym_id = r.anonym_id
	ORDER BY anonym_id;
END