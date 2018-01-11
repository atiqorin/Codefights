/*Please add ; after each select statement*/
CREATE PROCEDURE placesOfInterest()
BEGIN
	SELECT alias.country, sum(alias.adventure_park) AS adventure_park, sum(alias.golf) AS golf, sum(alias.river_cruise) AS river_cruise, sum(alias.kart_racing) AS kart_racing
    FROM (
        SELECT country,
            CASE WHEN leisure_activity_type = 'Adventure park' THEN number_of_places ELSE 0 END AS adventure_park,
            CASE WHEN leisure_activity_type = 'Golf' THEN  number_of_places ELSE 0 END AS golf,
            CASE WHEN leisure_activity_type = 'River cruise' THEN number_of_places ELSE 0 END AS river_cruise,
            CASE WHEN leisure_activity_type = 'Kart racing' THEN number_of_places ELSE 0 END AS kart_racing

        FROM countryActivities
        ) alias
    GROUP by alias.country;
END