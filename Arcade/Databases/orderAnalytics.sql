DROP PROCEDURE IF EXISTS orderAnalytics;
CREATE PROCEDURE orderAnalytics()
BEGIN

    CREATE OR REPLACE VIEW order_analytics AS
    SELECT id,
        year(order_date) AS year,
        quarter(order_date) AS quarter,
        type,
        quantity * price AS total_price
    FROM orders;

    SELECT *
    FROM order_analytics
    ORDER by id;
END;
