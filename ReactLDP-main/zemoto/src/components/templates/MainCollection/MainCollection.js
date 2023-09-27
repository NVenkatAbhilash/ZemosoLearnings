import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import CollectionViewItem from "../../molecules/CollectionViewItem/CollectionViewItem";

const useStyles = makeStyles({
    root:{
        padding: "0 40px 40px 40px",
    }
});

const MainCollection = ({foodImg, ...props}) => {
  const classes = useStyles();

  return (
    <Grid container justify="center" className={classes.root}>
      <Grid item sm={12}>
        <CollectionViewItem  foodImg={foodImg} {...props}/>
      </Grid>
    </Grid>
  );
};

export default MainCollection;
