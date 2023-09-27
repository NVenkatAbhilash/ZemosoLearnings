import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import Typography from "../../atoms/Typography/Typography";
import LocalityItems from "../../organisms/LocalityItems/LocalityItems";

const useStyles = makeStyles({
  root:{
    padding: "80px 0",
  },
  heading: {
      padding:"10px 60px",
  },
});

const Localities = () => {
  const classes = useStyles();

  return (
    <Grid container direction="column" className={classes.root} alignItems="center">
      <Grid item className={classes.heading}>
        <Typography variant="h4">Popular localities in and around Hyderabad</Typography>
      </Grid>
      <Grid item>
          <LocalityItems />
      </Grid>
    </Grid>
  );
};

export default Localities;
