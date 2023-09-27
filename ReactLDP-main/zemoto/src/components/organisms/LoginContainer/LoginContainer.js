import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import Typography from "../../atoms/Typography/Typography";
import { makeStyles } from "@material-ui/core/styles";
import auth from "../../../auth/initAuth";
import CloseIcon from "@material-ui/icons/Close";

const useStyles = makeStyles((theme) => ({
  container: {
    backgroundColor: "white",
    borderRadius: "10px",
    padding: "40px 20px",
    width: "500px",
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    borderRadius: "10px",
    opacity: ".8",
    textTransform: "capitalize",
    padding: "5px",
    fontSize: "22px",
  },
  google: {
    border: "1px solid rgb(100,100,100,.4)",
    padding: "18px",
    borderRadius: "10px",
    margin: "20px 0",
    textTransform: "capitalize",
    fontSize: "26px",
    opacity: ".7",
  },
  red: {
    color: "rgb(255,0,0,.7)",
    paddingLeft: "10px",
  },
  popup: {
    //display: "none",
    position: "fixed",
    zIndex: 1,
    left: 0,
    top: 0,
    paddingTop: "10vh",
    backgroundColor: "rgb(0,0,0,.9)",
    width: "100vw",
    height: "100vh",
  },
  link: {
    display: "inline",
    cursor: "pointer",
  },
}));

export default function LoginContainer({setDisplay, setOtherDisplay ,...props}) {
  const classes = useStyles();

  const [email, setEmail] = useState("");

  const [password, setPassword] = useState("");

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
    //console.log(email);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e, data) => {
    e.preventDefault();
    //console.log(email+" "+password);
    auth.login(email, password);
  };
  const handleLoginWithGoogle = (e) => {
    e.preventDefault();
    auth.loginWithGoogle();
  };

  return (
    <div className={classes.popup} {...props}>
      <Grid container justify="center">
        <Grid container className={classes.container}>
          <Grid item container alignItems="baseline">
            <Grid item sm>
              <Typography variant="h4">Login</Typography>
            </Grid>
            <Grid item>
              <CloseIcon
                fontSize="small"
                onClick={() => setDisplay(false)}
                data-testid="close"
              />
            </Grid>
          </Grid>
          <form className={classes.form} noValidate>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              label="Email Address"
              name="email"
              autoComplete="email"
              autoFocus
              onKeyUp={handleEmailChange}
              data-testid="email"
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              autoComplete="current-password"
              onKeyUp={handlePasswordChange}
              data-testid="password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="secondary"
              className={classes.submit}
              onClick={handleSubmit}
              data-testid="button"
            >
              Sign In
            </Button>
            <Grid container justify="center">
              <Grid item>
                <Typography variant="h6">or</Typography>
              </Grid>
            </Grid>

            <Button
              type="submit"
              fullWidth
              className={classes.google}
              onClick={handleLoginWithGoogle}
              data-testid="googleLogin"
            >
              Continue with Google
            </Button>
            <Grid container>
              <Grid item>
                <Typography>New to Zemoto? </Typography>
              </Grid>
              <Grid item>
                <div
                  className={classes.link}
                  onClick={() => {
                    setDisplay(false);
                    setOtherDisplay(true);
                  }}
                  data-testid="signUp"
                >
                  <Typography>
                    <span className={classes.red}> Sign Up</span>
                  </Typography>
                </div>
              </Grid>
            </Grid>
          </form>
        </Grid>
      </Grid>
    </div>
  );
}

/*
  _handleSubmit = (e, data) => {
    e.preventDefault();
    auth.login(this.state.email, this.state.password);
  };
  _handleLoginWithGoogle = (e) => {
    e.preventDefault();
    auth.loginWithGoogle();
  };


  <Grid container justify="center">
              <Grid item>
                <Typography variant="h7">OR</Typography>
              </Grid>
            </Grid>

            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="secondary"
              className={classes.submit}
              onClick={handleLoginWithGoogle}
            >
              Continue with Google
            </Button>

            
*/
