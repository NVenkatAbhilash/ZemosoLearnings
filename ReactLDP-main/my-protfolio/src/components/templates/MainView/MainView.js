import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import coverPhoto from "../../../images/landing-page.png";
import TypographyComponent from "../../atoms/Typography/Typography";

const useStyles = makeStyles({
  root: {
    width: "100%",
    height: "100vh",
    backgroundImage: `linear-gradient( 135deg, rgba(0, 64, 77, 0.9) 0%, rgba(0, 0, 0, .8) 100% ), url(${coverPhoto})`,
    backgroundRepeat:"no-repeat",
    backgroundPosition: "center",
    backgroundColor: "rgba(0, 0, 0, .8)",
  },
});

const MainView = (props) => {
  const classes = useStyles();

  return (
    <Grid className={classes.root} container direction="column" alignItems="center" justify="center">
      <Grid item>
        <TypographyComponent mode="largeSpacing capitalize">
          abhilash
        </TypographyComponent>
      </Grid>
      <Grid item>
        <TypographyComponent mode="heading coloured capitalize">
          &#123; Zemoso dev intern &#125;
        </TypographyComponent>
      </Grid>
      <Grid>
        <TypographyComponent mode="capitalize smallFont">Front-End  .  React  .  Java  .  C  .  Python</TypographyComponent>
      </Grid>
    </Grid>
  );
};

export default MainView;
