import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import ColouredHR from "../../atoms/ColouredHR/ColouredHR";
import TypographyComponent from "../../atoms/Typography/Typography";
import ContactMeForm from "../../organisms/ContactMeForm/ContactMeForm";
import SocialMediaIcons from "../../organisms/SocialMediaIcons/SocialMediaIcons";

const useStyles = makeStyles({
  root: {
    width: "100%",
    minHeight: "100vh",
    backgroundColor: "rgba(0, 0, 0, .9)",
    padding: "20px",
  },
});

const ContactMe = (props) => {
  const classes = useStyles();

  return (
    <Grid
      container
      className={classes.root}
      alignItems="center"
      justify="center"
      direction="column"
    >
      <Grid item>
        <TypographyComponent mode="heading">Get in Touch</TypographyComponent>
        </Grid>
        <Grid item>
        <ContactMeForm />
        <SocialMediaIcons />
        <ColouredHR />
      </Grid>
    </Grid>
  );
};

export default ContactMe;
