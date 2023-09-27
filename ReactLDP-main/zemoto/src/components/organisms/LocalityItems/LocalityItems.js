import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import LocalityViewItem from "../../molecules/LocalityViewItem/LocalityViewItem";
import { Link } from "react-router-dom";

const useStyles = makeStyles({
  root: {
    padding: "40px",
  },
});

const LocalityItems = (props) => {
  const classes = useStyles();

  return (
    <Grid container className={classes.root} spacing={2} {...props}>
      {viewType.map((value, index) => {
        return (
          <Grid item md={4} sm={6} xs={12} key={index}>
            <Link to="/viewType/delivery" style={{ textDecoration: "inherit" }}>
              <LocalityViewItem {...value} ></LocalityViewItem>
            </Link>
          </Grid>
        );
      })}
    </Grid>
  );
};

const viewType = [
  {
    placesCount: 363,
    placeName: "Jubilee Hills",
  },
  {
    placesCount: 84,
    placeName: "Gachibowli",
  },
  {
    placesCount: 264,
    placeName: "Hitech City",
  },
  {
    placesCount: 93,
    placeName: "Madhapur",
  },
  {
    placesCount: 1153,
    placeName: "Kukatpally",
  },
  {
    placesCount: 166,
    placeName: "Begumpet",
  },
  {
    placesCount: 261,
    placeName: "Tolichowki",
  },
  {
    placesCount: 231,
    placeName: "Ameerpet",
  },
  {
    placesCount: 87,
    placeName: "Film Nagar",
  },
  {
    placesCount: 122,
    placeName: "Paradise Circle",
  },
  {
    placesCount: 48,
    placeName: "Necklace Road",
  },
  {
    placesCount: 363,
    placeName: "Jubilee Hills",
  },
  {
    placesCount: 84,
    placeName: "Gachibowli",
  },
  {
    placesCount: 264,
    placeName: "Hitech City",
  },
  {
    placesCount: 93,
    placeName: "Madhapur",
  },
  {
    placesCount: 1153,
    placeName: "Kukatpally",
  },
  {
    placesCount: 166,
    placeName: "Begumpet",
  },
  {
    placesCount: 261,
    placeName: "Tolichowki",
  },
];

export default LocalityItems;
