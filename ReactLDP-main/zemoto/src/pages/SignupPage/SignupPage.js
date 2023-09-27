import React from "react";
import { Grid } from "@material-ui/core";
import SignupContainer from "../../components/organisms/SignupContainer/SignupContainer";
const SignupPage = (props) => {

  return (
    <Grid container direction="row" justify="center">
      <SignupContainer />
    </Grid>
  );
};

export default SignupPage;
