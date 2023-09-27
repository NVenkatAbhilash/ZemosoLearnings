import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import HeaderViewItem from "../../molecules/HeaderViewItem/HeaderViewItem";
import foodImg1 from "./../../../resources/images/collection2.jpg";
import foodImg2 from "./../../../resources/images/collection4.jpg";
import foodImg3 from "./../../../resources/images/collection3.jpg";
import foodImg4 from "./../../../resources/images/collection5.jpg";
import { Link } from "react-router-dom";

const useStyles = makeStyles({
  root: {
    padding: "40px 40px 80px 40px",
  },
});

const ViewTypeItem = (props) => {
  const classes = useStyles();

  return (
    <Grid container alignItems="stretch" justify="space-evenly" className={classes.root} spacing={2} {...props}>
      <Grid item md={3} sm={6} xs={12}>
        <Link to="/viewType/delivery" style={{ textDecoration: 'none' }}>
          <HeaderViewItem foodImg={foodImg1}>Order Food Online</HeaderViewItem>
        </Link>
      </Grid>
      <Grid item md={3} sm={6} xs={12}>
      <Link to="/viewType/dineOut" style={{ textDecoration: 'none' }}>
        <HeaderViewItem foodImg={foodImg2}>Go out for a meal</HeaderViewItem>
        </Link>
      </Grid>
      <Grid item md={3} sm={6} xs={12}>
      <Link to="/viewType/nightLife" style={{ textDecoration: 'none' }}>
        <HeaderViewItem foodImg={foodImg3}>
          Nightlife &#38; Clubs
        </HeaderViewItem></Link>
      </Grid>
      <Grid item md={3} sm={6} xs={12}>
        <HeaderViewItem foodImg={foodImg4}>Zomato Pro</HeaderViewItem>
      </Grid>
    </Grid>
  );
};

export default ViewTypeItem;
