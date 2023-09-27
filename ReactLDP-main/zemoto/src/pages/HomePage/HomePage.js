import React from "react";
import { Grid } from "@material-ui/core";
import HomeView from "../../components/templates/HomeView/HomeView";
import Collections from "../../components/templates/Collections/Collections";
import Localities from "../../components/templates/Localities/Localities";

const HomePage = (props) => {

  return (
    <Grid container direction="column">
      <Grid item>
        <HomeView {...props}/>
      </Grid>
      <Grid item>
        <Collections />
      </Grid>
      <Grid item>
          <Localities />
      </Grid>
    </Grid>
  );
};

export default HomePage;
