/*
1. Find out the PG-13 rated comedy movies. DO NOT use the film_list table.
*/

/*
SELECT Film.Title
FROM Film, film_category, category
WHERE Film.Film_ID = film_category.Film_ID
	AND film_category.category_id = category.category_id
    AND category.name = 'Comedy';
*/

/*
2. Find out the top 3 rented horror movies.
*/

/*
SELECT DISTINCT film.Title
FROM film, category,film_category,inventory
WHERE film.film_id = film_category.film_id
	AND film_category.category_id = category.category_id
    AND film.film_id = inventory.film_id
    AND category.name = 'horror'
    LIMIT 3;
*/

/*
3. Find out the list of customers from India who have rented sports movies.
*/

/*
SELECT customer.first_name, customer.last_name 
FROM customer,rental,address,city,country,film,film_category,category,inventory
WHERE customer.customer_id = rental.customer_id
	AND rental.inventory_id = inventory.inventory_id
    AND inventory.film_id = film.film_id
    AND film.film_id = film_category.film_id
    AND film_category.category_id = category.category_id
    AND category.name = 'Sports'
    AND customer.address_id = address.address_id
    AND address.city_id = city.city_id
    AND city.country_id = country.country_id
    AND country.country = 'India';
*/

/*
4. Find out the list of customers from Canada who have rented “NICK WAHLBERG” movies.
*/

/*
SELECT customer.first_name, customer.last_name 
FROM customer,rental,address,city,country,film,film_actor,actor,inventory
WHERE customer.customer_id = rental.customer_id
	AND rental.inventory_id = inventory.inventory_id
    AND inventory.film_id = film.film_id
    AND film.film_id = film_actor.film_id
    AND film_actor.actor_id = actor.actor_id
    AND actor.first_name = 'NICK'
    AND actor.last_name = 'WAHLBERG'
    AND customer.address_id = address.address_id
    AND address.city_id = city.city_id
    AND city.country_id = country.country_id
    AND country.country = 'Canada';
*/


/*
5. Find out the number of movies in which “SEAN WILLIAMS” acted.
*/

/*
SELECT count(*) as 'Number of Movies'
FROM film,film_actor,actor
WHERE film.film_id = film_actor.film_id
    AND film_actor.actor_id = actor.actor_id
    AND actor.first_name = 'SEAN'
    AND actor.last_name = 'WILLIAMS';
/*