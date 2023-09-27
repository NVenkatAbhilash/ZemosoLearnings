import React from "react";
import RoomRoundedIcon from "@material-ui/icons/LocationOn";
import TextField from "../../atoms/TextField/TextField";
import { makeStyles } from "@material-ui/core/styles";
import { Grid } from "@material-ui/core";
import SearchIcon from "@material-ui/icons/Search";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

const useStyles = makeStyles({
  root: {
    backgroundColor: "white",
    padding: "20px",
    borderRadius: "10px",
    //minWidth: "1100px",
    width: "100%",
  },
  icon: {
    fontSize: "25px",
    paddingRight: "12px",
    color: "rgb(255,0,0,.4)",
  },
  locationInput: {
    width: "20%",
  },
  line: {
    height: "30px",
    width: "2px",
    backgroundColor: "rgb(0,0,0,.1)",
    margin: "0 16px 0 10px",
  },
  searchIcon: {
    opacity: ".4",
    fontSize: "30px",
    color: "black",
  },
  arrowIcon: {
    opacity: ".5",
    fontSize: "25px",
    color: "black",
  },
  shadowBorder: {
    border: "1px solid rgb(100,100,100,.1)",
    boxShadow: "0 2px 6px rgb(100, 100, 100, 0.2)",
    //minWidth: "900px",
  },
  searchBar: {
    width:"80%",
  }
});

const SetLocation = ({shadowBorder, ...props}) => {
  const classes = useStyles();

  let rootClass = classes.root;

  if(shadowBorder){
      rootClass += " "+ classes.shadowBorder;
  }

  return (
    <Grid container alignItems="center" className={rootClass} {...props}>
      <Grid item>
        <RoomRoundedIcon className={classes.icon} />
      </Grid>
      <Grid item className={classes.locationInput}>
        <TextField placeholder="Hyderabad" />
      </Grid>
      <Grid item className={classes.arrowIcon}>
        <ArrowDropDownIcon />
      </Grid>
      <Grid item>
        <div className={classes.line}></div>
      </Grid>
      <Grid item sm className={classes.searchBar}>
        <TextField
          size="small"
          placeholder="Search for restaurant, cuisine or a dish"
        />
      </Grid>
      <Grid item>
        <SearchIcon className={classes.searchIcon} />
      </Grid>
    </Grid>
  );
};

/*
const places = [
  "Vizag",
  "Hyderabad",
  "Kakinada",
  "Rajamundry",
  "Samalkota",
  "Vizyanagaram",
  "Warangal",
  "Delhi",
];

<Autocomplete
          disableClearable
          options={places}
          fullWidth
          renderInput={(params) => (
            <TextField
              {...params}
              InputProps={{ ...params.InputProps, disableUnderline: true }}
              placeholder="Hyderabad"
            />
          )}
        />
*/

export default SetLocation;
