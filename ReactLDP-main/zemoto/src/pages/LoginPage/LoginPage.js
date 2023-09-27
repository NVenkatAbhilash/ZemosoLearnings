import React from "react";
import { Grid } from "@material-ui/core";
import LoginContainer from "../../components/organisms/LoginContainer/LoginContainer";
const LoginPage = (props) => {

  return (
    <Grid container direction="row" justify="center">
      <LoginContainer />
    </Grid>
  );
};

export default LoginPage;
