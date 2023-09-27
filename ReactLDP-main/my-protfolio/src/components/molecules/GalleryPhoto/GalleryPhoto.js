import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import TypographyComponent from "../../atoms/Typography/Typography";

const useStyles = makeStyles({
  root: {
    paddingBottom: "40px",
  },
  image: {
    height: "250px",
    objectFit: "cover",
    width: "300px",
    //boxShadow: "0 8px 10px 4px rgba(200, 200, 200, 0.2), 0 6px 20px 0 rgba(200, 200, 200, 0.19)",
  },
});

const GalleryPhoto = (props) => {
  const classes = useStyles();
  return (
    <Grid container direction="row" className={classes.root} justify="center">
      <Grid item>
        <img className={classes.image} src={props.picture} />
      </Grid>
      <Grid item>
        <TypographyComponent mode="coloured capitalize largeSpacing">
          {props.information}
        </TypographyComponent>
      </Grid>
    </Grid>
  );
};

export default GalleryPhoto;
