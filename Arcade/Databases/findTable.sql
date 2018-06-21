/*Please add ; after each select statement*/
CREATE PROCEDURE findTable()
BEGIN
    SELECT
        a.TABLE_NAME AS tab_name,
        a.COLUMN_NAME AS col_name,
        a.DATA_TYPE AS data_type
    FROM INFORMATION_SCHEMA.COLUMNS a
        JOIN(
            SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES
            WHERE TABLE_NAME LIKE BINARY 'e%s'
        ) b
    ON b.TABLE_NAME = a.TABLE_NAME
    WHERE a.TABLE_SCHEMA = 'ri_db'
    ORDER BY a.TABLE_NAME, a.COLUMN_NAME;
END