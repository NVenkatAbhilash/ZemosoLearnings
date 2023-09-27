import { useState } from "react";
import collection1 from "../resources/images/collection1.jpg";
import collection2 from "../resources/images/collection2.jpg";
import collection3 from "../resources/images/collection3.jpg";
import collection4 from "../resources/images/collection4.jpg";
import collection5 from "../resources/images/collection5.jpg";

export default function useRestaurantsFilter() {
  const [restaurants, setRestaurantsFilter] = useState(() => restaurantsList);

  const defaultFilter = {
    sort: "",
    rating: "0",
    cost: "0",
    cuisine: [],
  };

  const [filter, setFilter] = useState(defaultFilter);

  const applyFilter = (type, value) => {
    console.log("apply filter called",type,value);
    const newFilter = filter;
    newFilter[type] = value;
    setFilter(newFilter);
    let newRestaurants = [...restaurantsList];
    console.log(newFilter, filter);
    if (filter["sort"] !== "") {
      switch (filter["sort"]) {
        case "rating":
          newRestaurants = newRestaurants.sort(
            (restaurantOne, restaurantTwo) =>
              restaurantTwo.rating - restaurantOne.rating
          );
          break;
        case "time":
          newRestaurants = newRestaurants.sort(
            (restaurantOne, restaurantTwo) =>
              restaurantOne.time - restaurantTwo.time
          );
          break;
        case "cost asc":
          newRestaurants = newRestaurants.sort(
            (restaurantOne, restaurantTwo) =>
              restaurantTwo.cost - restaurantOne.cost
          );

          break;
        case "cost dec":
          newRestaurants = newRestaurants.sort(
            (restaurantOne, restaurantTwo) =>
              restaurantOne.cost - restaurantTwo.cost
          );
          break;
      }
    }
    if (filter["rating"] !== "0") {
      const value = parseInt(filter["rating"]);
      newRestaurants = newRestaurants.filter(
        (restaurant) => restaurant.rating >= value
      );
    }
    if (filter["cost"] !== "0") {
      const value = parseInt(filter["cost"]);
      newRestaurants = newRestaurants.filter(
        (restaurant) => restaurant.cost >= value
      );
    }
    if (filter["cuisine"].length !== 0) {
      newRestaurants = newRestaurants.filter((restaurant) =>
        restaurant.foodTypes.some((foodType) =>
          filter["cuisine"].includes(foodType)
        )
      );
    }
    setRestaurantsFilter(newRestaurants);
  };

  return [restaurants, applyFilter];
}

export const restaurantsList = [
  {
    image: collection2,
    name: "Sr Balaki Famili Dhaba",
    rating: 3.8,
    reviews: "15.2K",
    foodTypes: ["North Indian", "Chinese", "Biriyani"],
    cost: 250,
    time: 34,
    pro: 15,
    flat: 150,
  },
  {
    image: collection1,
    name: "Hotel Shadab",
    rating: 2.4,
    reviews: "10K",
    foodTypes: ["Mughali", "Hyderabadi", "Biriyani"],
    cost: 350,
    time: 24,
    pro: 15,
    flat: 150,
  },
  {
    image: collection3,
    name: "The Bhimavaram Boys",
    rating: 3.6,
    reviews: "5003",
    foodTypes: ["South Indian"],
    cost: 150,
    time: 44,
    pro: 15,
    flat: 150,
  },
  {
    image: collection4,
    name: "Shah Ghouse Hotel & Restaurant",
    rating: 4.4,
    reviews: "75.2K",
    foodTypes: ["North Indian", "Kebhab", "Biriyani"],
    cost: 300,
    time: 34,
    pro: 15,
    flat: 150,
  },
  {
    image: collection5,
    name: "Shree Golden Place",
    rating: 3.9,
    reviews: "15.6K",
    foodTypes: ["North Indian", "Chinese", "Biriyani"],
    cost: 300,
    time: 47,
    pro: 15,
    flat: 150,
  },
  {
    image: collection2,
    name: "Baba Bakery",
    rating: 4.4,
    reviews: "25.4K",
    foodTypes: ["Bakery", "North Indian"],
    cost: 100,
    time: 40,
    pro: 15,
    flat: 150,
  },
  {
    image: collection3,
    name: "Gabru Di Chaap",
    rating: 3.6,
    reviews: "192",
    foodTypes: ["North Indian", "Wraps"],
    cost: 150,
    time: 44,
    pro: 15,
    flat: 150,
  },
  {
    image: collection4,
    name: "Pista House",
    rating: 2.3,
    reviews: "1090",
    foodTypes: ["Bakery", "Italian", "Fast Food"],
    cost: 1000,
    time: 35,
    pro: 15,
    flat: 150,
  },
  {
    image: collection1,
    name: "Pizza Hut",
    rating: 3.3,
    reviews: "46.2K",
    foodTypes: ["Pizza", "Fast Food"],
    cost: 650,
    time: 54,
    pro: 15,
    flat: 150,
  },
  {
    image: collection2,
    name: "Shah Ghouse Spl Shawarma",
    rating: 4.2,
    reviews: "5,938",
    foodTypes: ["Lebanese", "Bakery", "Fast Food"],
    cost: 150,
    time: 49,
    pro: 15,
    flat: 150,
  },
  {
    image: collection5,
    name: "Lazzat Restaurant",
    rating: 4.1,
    reviews: "45.6K",
    foodTypes: ["Mughlai", "Hyderabadi", "Biriyani"],
    cost: 550,
    time: 37,
    pro: 15,
    flat: 150,
  },
  {
    image: collection2,
    name: "McDonald's",
    rating: 1.1,
    reviews: "25.4K",
    foodTypes: ["Burger", "Fast Food"],
    cost: 450,
    time: 54,
    pro: 15,
    flat: 150,
  },
];
