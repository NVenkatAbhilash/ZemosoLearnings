import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import ColouredHR from "../../atoms/ColouredHR/ColouredHR";
import TypographyComponent from "../../atoms/Typography/Typography";
import MyPhoto from "../../atoms/MyPhoto/MyPhoto";

const useStyles = makeStyles({
  root: {
    width: "100%",
    minHeight: "100vh",
    backgroundColor: "rgba(0, 0, 0, .9)",
  },
});

const AboutMe = (props) => {
  const classes = useStyles();

  return (
    <Grid
      className={classes.root}
      container
      direction="column"
      alignItems="center"
      justify="center"
    >
      <Grid
        item
        container
        direction="row"
        alignItems="center"
        lg={6}
        sm={10}
        xs={11}
      >
        <Grid item lg={4} sm={5} xs={12}>
          <MyPhoto />
        </Grid>
        <Grid
          item
          container
          direction="column"
          lg={8}
          sm={7}
          spacing={4}
          xs={12}
        >
          <Grid item container spacing={2}>
            <Grid item>
              <TypographyComponent mode="heading">
                Who are you?
              </TypographyComponent>
            </Grid>
            <Grid item container>
              <TypographyComponent mode="smallFont">
                I'm Abhilash, a marvel fan, 21-something-year-old zemoso dev
                intern doing work based in Hyderabad.
              </TypographyComponent>
            </Grid>
            <Grid item>
              <TypographyComponent mode="smallFont">
                I started creating cool web designs using HTML and CSS back in
                2016. I am a React Enthusiast and extremely passionate about
                coding. I love to learn new things every day and keep up with
                the new technologies. In many ways, websites are my first love.
              </TypographyComponent>
            </Grid>
            <Grid item>
              <TypographyComponent mode="smallFont">
                Last but not least, one of my favorite activities is to educate
                and mentor others in the field to fulfill their potential and
                deepen my knowledge.
              </TypographyComponent>
            </Grid>
          </Grid>
        </Grid>
        <Grid item lg={12} sm={12} xs={12}>
          <ColouredHR />
        </Grid>
      </Grid>
    </Grid>
  );
};

export default AboutMe;
