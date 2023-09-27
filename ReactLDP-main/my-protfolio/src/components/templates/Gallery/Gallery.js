import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import GalleryPhotos from "../../organisms/GalleryPhotos/GalleryPhotos";
import TypographyComponent from "../../atoms/Typography/Typography";
import ColouredHR from "../../atoms/ColouredHR/ColouredHR";

const useStyles = makeStyles({
  root: {
    width: "100%",
    minHeight: "100vh",
    backgroundColor: "rgba(0, 0, 0, .9)",
  },
  heading: {
    padding: "60px 0",
  },
});

const Gallery = (props) => {
  const classes = useStyles();

  return (
    <Grid
      className={classes.root}
      container
      direction="column"
      alignItems="center"
      justify="center"
    >
      <Grid item className={classes.heading}>
        <TypographyComponent mode="heading capitalize">
          Gallery
        </TypographyComponent>
      </Grid>
      <Grid item lg={9} md={10} sm={11} xs={11}>
        <GalleryPhotos />
        <ColouredHR />
      </Grid>
    </Grid>
  );
};

export default Gallery;
