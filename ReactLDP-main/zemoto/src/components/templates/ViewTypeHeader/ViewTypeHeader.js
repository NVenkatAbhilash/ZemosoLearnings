import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import Typography from "../../atoms/Typography/Typography";
import SetLocation from "../../organisms/setLocation/setLocation";
import logo from "../../../resources/images/logoBlack.webp";
import { Link } from "react-router-dom";
import auth from "../../../auth/initAuth";

const useStyles = makeStyles({
  root: {
    padding: "20px 70px 40px 70px",
    color: "rgb(100,100,100,.7)",
  },
  logo: {
    width: "200px",
  },
  faded: {
    color: "rgb(100,100,100,.4)",
  },
});

const logout = () => {
  auth.logout();
  window.location.replace("http://localhost:3000/");
};

const ViewTypeHeader = () => {
  const classes = useStyles();

  return (
    <Grid container direction="column" className={classes.root} spacing={6}>
      <Grid item container direction="row" alignItems="center" spacing={4}>
        <Grid item>
          <Link to="/" style={{ textDecoration: "none" }}>
            <img alt="logo" className={classes.logo} src={logo} />
          </Link>
        </Grid>
        <Grid item lg>
          <SetLocation shadowBorder />
        </Grid>
        <Grid item lg={2} justify="flex-end" container spacing={4}>
          <Grid item onClick={logout} data-testid="logoutLink">
            <Typography mode="link" variant="h6">
              Logout
            </Typography>
          </Grid>
        </Grid>
      </Grid>
      <Grid item>
        <Typography variant="subtitle2">
          Home / India / Hyderabad / Hyderabad City /{" "}
          <span className={classes.faded}>Charminar Restaurants</span>
        </Typography>
      </Grid>
    </Grid>
  );
};

export default ViewTypeHeader;
