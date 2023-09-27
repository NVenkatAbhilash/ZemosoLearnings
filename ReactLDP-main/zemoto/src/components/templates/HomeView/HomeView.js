import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import bgPhoto from "../../../resources/images/headerBg.jpg";
import logo from "../../../resources/images/logo.webp";
import SetLocation from "../../organisms/setLocation/setLocation";
import ViewTypeItem from "../../organisms/ViewTypeItems/ViewTypeItem";
import { Link } from "react-router-dom";
import Typography from "../../atoms/Typography/Typography";
import auth from "../../../auth/initAuth";
import LoginContainer from "../../organisms/LoginContainer/LoginContainer";
import SignupContainer from "../../organisms/SignupContainer/SignupContainer";

const useStyles = makeStyles({
  root: {
    backgroundImage: `linear-gradient(rgba(0,0,0, 0.5), rgb(0, 0, 0, .5)), url(${bgPhoto})`,
    height: "800px",
    //width: "100%",
    backgroundSize: "cover",
    backgroundPosition: "center",
    color: "white",
  },
  logo: {
    width: "25vw",
    minWidth: "250px",
  },
  topPart: {
    padding: "40px 80px 0 80px",
  },
  pointer: {
    cursor: "pointer",
  },
  search: {
    minWidth: "70vw",
    maxWidth: "95vw",
  },
});

const SignupView = (setDisplayLogin,setDisplaySignup) => {
  return (
    <React.Fragment>
      <Grid item onClick={()=>setDisplayLogin(true)} data-testid="loginButton">
        <Typography mode="link" variant="h6">
          Log in
        </Typography>
      </Grid>

      <Grid item onClick={()=>setDisplaySignup(true)} data-testid="signupButton">
        <Typography mode="link" variant="h6">
            Sign up
        </Typography>
      </Grid>
    </React.Fragment>
  );
};
const logout = () => {
  auth.logout();
  window.location.replace("http://localhost:3000/");
};

const LogoutView = () => {
  return (
    <Grid item onClick={logout} data-testid="logoutButton">
      <Typography mode="link" variant="h6">
        Logout
      </Typography>
    </Grid>
  );
};

const HomeView = ({location ,...props}) => {
  const classes = useStyles();

  const hash = location.hash;
  if (hash) {
    const ind = hash.indexOf("id_token");
    localStorage.setItem("id_token", hash.substring(ind + 9, hash.length));
  }

  let loginInUrl = false;

  if(location.search.indexOf("login")!==-1){
    loginInUrl = true;
  }

  const [displayLogin, setDisplayLogin] = useState(loginInUrl);
  const [displaySignup, setDisplaySignup] = useState(false);


  return (
    <Grid container spacing={7}>
      {displaySignup && <SignupContainer setDisplay={setDisplaySignup} setOtherDisplay={setDisplayLogin}/>}
      {displayLogin && <LoginContainer setDisplay={setDisplayLogin}  setOtherDisplay={setDisplaySignup}/>}
      <Grid item container direction="column" className={classes.root}>
        <Grid item container spacing={7} className={classes.topPart}>
          <Grid item sm>
            <Typography mode="link" variant="subtitle2">
              Get the App
            </Typography>
          </Grid>
          {auth.loggedIn() ? LogoutView() : SignupView(setDisplayLogin,setDisplaySignup)}
        </Grid>
        <Grid item sm={2}></Grid>

        <Grid
          item
          container
          direction="column"
          justify="center"
          alignItems="center"
          spacing={5}
        >
          <Grid item>
            <img alt="logo" className={classes.logo} src={logo} />
          </Grid>
          <Grid
            item
            container
            alignItems="baseline"
            justify="center"
            spacing={2}
          >
            <Grid item>
              <Typography variant="h4">
                Discover the best food &#38; drinks in
              </Typography>
            </Grid>
            <Grid item>
              <Typography variant="h5">Hyderabad</Typography>
            </Grid>
          </Grid>
          <Grid item sm={12} className={classes.search}>
            <SetLocation />
          </Grid>
        </Grid>
      </Grid>
      <Grid item>
        <ViewTypeItem />
      </Grid>
    </Grid>
  );
};

export default HomeView;
