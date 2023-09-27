import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import Typography from "../../atoms/Typography/Typography";
import ArrowRightIcon from "@material-ui/icons/ArrowRight";
import CollectionItems from "../../organisms/CollectionItems/CollectionItems";

const useStyles = makeStyles({
  root: {
      paddingLeft: "40px",
  },
  subHeading:{
      color: "rgb(0,0,0,.7)",
      
  },
  link:{
      color: "rgb(255,0,0,.5)",
      cursor: "pointer",
  }
});

const Collections = (props) => {
  const classes = useStyles();

  return (
    <Grid container direction="column" className={classes.root} {...props}>
      <Grid item>
        <Typography variant="h4">Collections</Typography>
      </Grid>
      <Grid item container direction="row">
        <Grid item lg  className={classes.subHeading}>
          <Typography variant="subtitle1">
            Explore curated lists of top restaurants, cafes, pubs, and bars in
            Hyderabad, based on trends
          </Typography>
        </Grid>
        <Grid item container alignItems="flex-end" justify="flex-end" lg={3} className={classes.link}>
          <Grid item>
            <Typography mode="link" variant="subtitle1">All Collections in Hyderabad</Typography>
          </Grid>
          <Grid item>
            <ArrowRightIcon fontSize="small" />
          </Grid>
        </Grid>
      </Grid>
      <Grid item>
          <CollectionItems />
      </Grid>
    </Grid>
  );
};

export default Collections;
