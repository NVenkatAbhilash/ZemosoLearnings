import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import Typography from "../../atoms/Typography/Typography";
import Collections from "../../templates/Collections/Collections";
import { Link } from "react-router-dom";

const useStyles = makeStyles({
  root: {
    padding: "0 40px",
  },
  item: {
    margin: "20px 0",
  },
  subHeading: {
    color: "rgb(100,100,100,.9)",
    cursor: "pointer",
  },
  active: {
    color: "rgb(240,0,0,.7)",
    borderBottom: "3px solid rgb(240,0,0,.5)",
  },
  subHeadingBar: {
    padding: "0 0 60px 36px",
  },
  link: {
    textDecoration: "none",
    color: "inherit",
  },
});

const viewTypeList = [
  {
    name: "Delivery",
    heading: "Delivery",
    link: "delivery",
  },
  {
    name: "Dining Out",
    heading: "Dine-Out",
    link: "dineOut",
  },
  {
    name: "Nightlife",
    heading: "Nightlife",
    link: "nightLife",
  },
];

const ViewTypeHeadings = ({active, ...props}) => {
  const classes = useStyles();

  let activeType = 0;
  if (active) {
    activeType = active;
  }

  return (
    <Grid container direction="column" className={classes.root} {...props}>
      <Grid
        item
        direction="row"
        container
        spacing={8}
        className={classes.subHeadingBar}
      >
        {viewTypeList.map((viewTypeItem, index) => {
          let classList = classes.subHeading;
          if (index === activeType) {
            classList += " " + classes.active;
          }
          return (
            <Grid item className={classList} key={index}>
              <Link
                to={"/viewType/" + viewTypeItem.link}
                className={classes.link}
              >
                <Typography variant="h5">{viewTypeItem.name}</Typography>
              </Link>
            </Grid>
          );
        })}
      </Grid>
      {activeType > 0 && (
        <Grid item className={classes.greyBackground}>
          <Collections />
        </Grid>
      )}
      <Grid item>
        <Typography variant="h4">
          {viewTypeList[activeType].heading} Restaurants in Hyderabad
        </Typography>
      </Grid>
    </Grid>
  );
};

export default ViewTypeHeadings;
