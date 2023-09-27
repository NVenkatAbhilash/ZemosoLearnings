import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import Typography from "../../atoms/Typography/Typography";
import MoreCollectionItems from "../../organisms/MoreCollectionsItems/MoreCollectionItems";

const useStyles = makeStyles({
    root:{
      padding: "0 40px",
    }
});

const MoreCollectionView = (props) => {
  const classes = useStyles();

  return (
    <Grid container spacing={3} direction="column" className={classes.root}>
      <Grid item>
        <Typography variant="h6">More Collections</Typography>
      </Grid>
      <Grid item>
        <MoreCollectionItems />
      </Grid>
    </Grid>
  );
};

export default MoreCollectionView;
