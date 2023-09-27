import React from "react";
import { Grid } from "@material-ui/core";
import ViewTypeHeader from "../../components/templates/ViewTypeHeader/ViewTypeHeader";
import RestaurantItems from "../../components/organisms/RestaurantItems/RestaurantItems";
import MainCollection from "../../components/templates/MainCollection/MainCollection";
import MoreCollectionView from "../../components/templates/MoreCollectionsView/MoreCollectionView";

const CollectionsPage = (props) => {
  return (
    <Grid container direction="column">
      <Grid item>
        <ViewTypeHeader />
      </Grid>
      <Grid item>
        <MainCollection {...props} />
      </Grid>
      <Grid item>
        <RestaurantItems />
      </Grid>
      <Grid item>
        <MoreCollectionView />
      </Grid>
    </Grid>
  );
};

export default CollectionsPage;
