import React from "react";

import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles({
  line: {
    width: "100%",
    minWidth: "100px",
    height: "2px",
    background:
      "linear-gradient( to right, rgba(249, 105, 14, 1) 0%, rgba(102, 51, 153, 1) 100% )",
  },
  root: {
    paddingTop: "100px",
  }
});

const ColouredHR = (props) => {
  const classes = useStyles();


  return (
    <div className={classes.root}>
      <div className={classes.line} />
    </div>
  );
};

export default ColouredHR;
