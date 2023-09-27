import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Box, Grid } from "@material-ui/core";
import Typography from "../../atoms/Typography/Typography";
import StarBorderIcon from "@material-ui/icons/StarBorder";
import Rating from "@material-ui/lab/Rating";
import FiberManualRecordIcon from "@material-ui/icons/FiberManualRecord";

const useStyles = makeStyles({
  root: {
    maxWidth: "565px",
    position: "relative",
  },
  image: {
    width: "100%",
    height: "350px",
    objectFit: "cover",
    borderRadius: "20px",
  },
  heading: {
    fontWeight: "500",
  },
  rating: {
    padding: "0 8px",
  },
  reviews: {
    color: "rgb(100,100,100,.6)",
  },
  foodTypes: {
    color: "rgb(100,100,100,.9)",
  },
  dot: {
    color: "rgb(100,100,100,.5)",
    fontSize: "10px",
    padding: "4px 10px",
  },
  costAndTime: {
    color: "rgb(100,100,100,.7)",
  },
});

const Restaurant = ({
  foodTypes,
  image,
  name,
  rating,
  reviews,
  cost,
  time,
  ...props
}) => {
  const classes = useStyles();

  if (foodTypes) {
    foodTypes = foodTypes.join(", ");
  } else {
    foodTypes = "";
  }

  return (
    <Grid
      container
      direction="column"
      alignItems="flex-start"
      className={classes.root}
      {...props}
    >
      <Grid item>
        <img alt="restaurant pic" className={classes.image} src={image} />
      </Grid>
      <Grid item className={classes.content}>
        <Typography className={classes.heading} variant="h6" data-testid="name">
          {name}
        </Typography>
      </Grid>
      <Grid item container direction="row" alignItems="center">
        <Rating
          name="customized-empty"
          defaultValue={rating}
          precision={0.1}
          size="small"
          emptyIcon={<StarBorderIcon fontSize="inherit" />}
        />
        <Box className={classes.rating} data-testid="rating">
          <Typography>{rating}</Typography>
        </Box>
        <Box className={classes.reviews}>
          <Typography data-testid="reviews">({reviews} Delivery Reviews)</Typography>
        </Box>
      </Grid>
      <Grid item className={classes.foodTypes}>
        <Typography data-testid="foodTypes">{foodTypes}</Typography>
      </Grid>
      <Grid item className={classes.costAndTime}>
        <Typography data-testid="costAndTime">
          ₹{cost} per person
          <FiberManualRecordIcon className={classes.dot} />
          {time} min
        </Typography>
      </Grid>
    </Grid>
  );
};

export default Restaurant;
