import React from "react";
import { Grid } from "@material-ui/core";
import CollectionViewItem from "../../molecules/CollectionViewItem/CollectionViewItem";
import collection1 from "./../../../resources/images/collection1.jpg";
import collection2 from "./../../../resources/images/collection2.jpg";
import collection3 from "./../../../resources/images/collection3.jpg";
import collection4 from "./../../../resources/images/collection4.jpg";
import collection5 from "./../../../resources/images/collection5.jpg";
import { Link } from "react-router-dom";


const MoreCollectionItems = (props) => {

  return (
    <Grid container spacing={2} {...props}>
      {moreCollections.map((value, index) => {
        return (
          <Grid item md={3} sm={6} xs={12} key={index}>
            <Link
              to={{
                pathname: "/collections",
                state: {
                  foodImg: value.photo,
                  ...value,
                },
              }}
              style={{ textDecoration: "none" }}
            >
              <CollectionViewItem {...value} mode="small" />
            </Link>
          </Grid>
        );
      })}
    </Grid>
  );
};

const moreCollections = [
  {
    placesCount: 12,
    special: "New Year's Specials",
    foodImg: collection1,
  },
  {
    placesCount: 31,
    special: "Trending This Week",
    foodImg: collection2,
  },
  {
    placesCount: 111,
    special: "Hyderabad's Hottest",
    foodImg: collection3,
  },
  {
    placesCount: 221,
    special: "Work Friendly Places!",
    foodImg: collection4,
  },
  {
    placesCount: 12,
    special: "Live Sports Screenings",
    foodImg: collection5,
  },
  {
    placesCount: 6,
    special: "Newly Opened",
    foodImg: collection2,
  },
  {
    placesCount: 12,
    special: "Great Breakfasts",
    foodImg: collection4,
  },
  {
    placesCount: 8,
    special: "Happy Hours",
    foodImg: collection1,
  },
  {
    placesCount: 8,
    special: "Best Milkshakes",
    foodImg: collection3,
  },
  {
    placesCount: 221,
    special: "Work Friendly Places!",
    foodImg: collection4,
  },
  {
    placesCount: 12,
    special: "Live Sports Screenings",
    foodImg: collection5,
  },
  {
    placesCount: 6,
    special: "Newly Opened",
    foodImg: collection2,
  },
];

export default MoreCollectionItems;
