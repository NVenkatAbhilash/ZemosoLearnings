import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Button, Grid } from "@material-ui/core";
import TypographyComponent from "../../atoms/Typography/Typography";

const useStyles = makeStyles({
  button: {
    color: "black",
    background:
      "linear-gradient( to right, rgba(249, 105, 14, 1) 0%, rgba(102, 51, 153, 1) 100% )",
  },
  form: {
    minHeight: "400px",
  },
  inputField: {
    height: "50px",
    border: "1px solid rgb(100, 100, 100, .7)",
    borderRadius: "10px",
    padding: "5px",
    width: "40vw",
    minWidth: "300px",
    fontSize: "20px",
  },
  spacing: {
    padding: "20px",
  },
  center: {
    textAlign: "center",
  },
  mediumHeight: {
    height: "80px",
  },
});

const ContactMeForm = (props) => {
  const classes = useStyles();

  return (
    <Grid item container justify="center" lg={12}>
      <form id="contact-form" className={classes.form}>
        <Grid
          item
          container
          direction="row"
          className={classes.spacing}
          lg={12}
        >
          <Grid item lg={2} sm={3}>
            <TypographyComponent mode="smallFont">Name *</TypographyComponent>
          </Grid>
          <Grid item lg={3} sm={4}>
            <input
              type="text"
              id="form-name"
              name="name"
              placeholder="Your name..."
              className={classes.inputField}
            />
          </Grid>
        </Grid>
        <Grid item container direction="row" className={classes.spacing}>
          <Grid item lg={2} sm={3}>
            <TypographyComponent mode="smallFont">Email *</TypographyComponent>
          </Grid>
          <Grid item lg={3} sm={4}>
            <input
              type="text"
              id="form-email"
              name="email"
              placeholder="Your email..."
              className={classes.inputField}
            />
          </Grid>
        </Grid>
        <Grid item container direction="row" className={classes.spacing}>
          <Grid item lg={2} sm={3}>
            <TypographyComponent mode="smallFont">Subject</TypographyComponent>
          </Grid>
          <Grid item lg={3} sm={4}>
            <textarea
              name="subject"
              placeholder="Write something..."
              className={classes.inputField + " " + classes.mediumHeight}
            ></textarea>
          </Grid>
        </Grid>
        <Grid item className={classes.center}>
          <Button className={classes.button} type="submit">
            Submit
          </Button>
        </Grid>
      </form>
    </Grid>
  );
};

export default ContactMeForm;
