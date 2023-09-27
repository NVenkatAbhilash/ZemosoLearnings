import React from "react";
import { Grid } from "@material-ui/core";
import ViewTypeHeader from "../../components/templates/ViewTypeHeader/ViewTypeHeader";
import RestaurantItems from "../../components/organisms/RestaurantItems/RestaurantItems";
import ViewTypeHeadings from "../../components/organisms/ViewTypeHeadings/ViewTypeHeadings";

const ViewTypePage = (props) => {
  return (
    <Grid container direction="column">
      <Grid item>
        <ViewTypeHeader />
      </Grid>
      <Grid item>
        <ViewTypeHeadings {...props} />
      </Grid>
      <Grid item>
        <RestaurantItems />
      </Grid>
    </Grid>
  );
};

export default ViewTypePage;
