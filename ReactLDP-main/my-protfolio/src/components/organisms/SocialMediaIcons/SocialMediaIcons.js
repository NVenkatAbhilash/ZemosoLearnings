import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import FacebookIcon from "@material-ui/icons/Facebook";
import EmailIcon from "@material-ui/icons/Email";
import LinkedInIcon from "@material-ui/icons/LinkedIn";

const useStyles = makeStyles({
  icon: {
    color: "white",
    margin: "30px",
    cursor: "pointer",
  },
});

const SocialMediaIcons = (props) => {
  const classes = useStyles();

  return (
    <Grid item container justify="center" lg={12}>
      <Grid
        item
        class={classes.icon}
        onClick={() =>
          window.open("https://www.facebook.com/abhilash.venkat.9", "_blank")
        }
      >
        <FacebookIcon />
      </Grid>

      <Grid
        item
        class={classes.icon}
        onClick={() =>
          window.open(
            "https://www.linkedin.com/mwlite/in/venkat-abhilash-n-a4900617b",
            "_blank"
          )
        }
      >
        <LinkedInIcon />
      </Grid>

      <Grid
        item
        class={classes.icon}
        onClick={() =>
          window.open(
            "https://mail.google.com/mail/?view=cm&fs=1&to=abhilash.notla@zemosolabs.com",
            "_blank"
          )
        }
      >
        <EmailIcon />
      </Grid>
    </Grid>
  );
};

export default SocialMediaIcons;
