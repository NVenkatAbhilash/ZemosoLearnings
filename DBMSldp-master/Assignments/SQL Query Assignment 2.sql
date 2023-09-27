/*
1. Find out the number of documentaries with deleted scenes.
*/

/*
SELECT count(*) as 'Number of Movies'
FROM film
WHERE special_features LIKE '%Deleted Scenes%'
*/

/*
2. Find out the number of sci-fi movies rented by the store managed by Jon Stephens.
*/

/*
SELECT count(film.film_id)
FROM film, category,film_category,inventory,rental,staff,store
WHERE film.film_id = film_category.film_id
	AND film_category.category_id = category.category_id
    AND category.name = 'Sci-Fi'
    AND store.store_id = staff.store_id
    AND staff.staff_id = rental.staff_id
    AND rental.inventory_id = inventory.inventory_id
    AND inventory.film_id = film.film_id
*/

/*
3. Find out the total sales from Animation movies.
*/

/*
SELECT count(film.film_id) as 'total sale'
FROM film, category,film_category,inventory,rental,staff,store
WHERE film.film_id = film_category.film_id
	AND film_category.category_id = category.category_id
    AND category.name = 'Animation'
    AND film.film_id = inventory.film_id
    AND inventory.store_id = store.store_id
 */   
    
/*
4. Find out the top 3 rented category of movies  by “PATRICIA JOHNSON”.
*/

/*
SELECT DISTINCT category.name
FROM customer,rental,inventory,film,film_category,category
WHERE customer.customer_id = rental.customer_id
	AND rental.inventory_id = inventory.inventory_id
    AND inventory.film_id = film.film_id
    AND film.film_id = film_category.film_id
    AND film_category.category_id = category.category_id
    AND customer.first_name = 'PATRICIA'
    AND customer.last_name = 'JOHNSON'
    LIMIT 3;
*/

/*
5. Find out the number of R rated movies rented by “SUSAN WILSON”.
*/

/*
SELECT count(film.film_id)
FROM customer,rental,inventory,film
WHERE customer.customer_id = rental.customer_id
	AND rental.inventory_id = inventory.inventory_id
    AND inventory.film_id = film.film_id
    AND customer.first_name = 'SUSAN'
    AND customer.last_name = 'WILSON'
    AND film.rating = 'R';
*/