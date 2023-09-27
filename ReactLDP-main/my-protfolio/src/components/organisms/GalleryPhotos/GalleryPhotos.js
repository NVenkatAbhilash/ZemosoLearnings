import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import galleryPhotos from "../../../gallery.js";
import GalleryPhoto from "../../molecules/GalleryPhoto/GalleryPhoto.js";

const useStyles = makeStyles({
  root: {},
});

const GalleryPhotos = (props) => {
  const classes = useStyles();

  return (
    <Grid container>
      {galleryPhotos.map((photo) => {
        return (
          <Grid item key={photo.id} lg={3} md={4} sm={6} xs={12}>
            <GalleryPhoto  {...photo} />
          </Grid>
        );
      })}
    </Grid>
  );
};

export default GalleryPhotos;
