import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import { Typography } from "@material-ui/core";

const useStyles = makeStyles({
  root: {
    color: "white",
    fontSize: "30px",
    display: "inline",
  },
  heading: {
    fontSize: "45px",
    fontWeight: "550",
    letterSpacing: "2px",
  },
  coloured: {
    color: "rgba(249, 105, 14, 1)",
    background:
      "linear-gradient( to right, rgba(249, 105, 14, 1) 0%, rgba(102, 51, 153, 1) 100% )",
    "-webkit-text-fill-color": "transparent",
    "-webkit-background-clip": "text",
  },
  smallSpacing: {
    letterSpacing: "1.5px",
  },
  largeSpacing: {
    letterSpacing: "8px",
  },
  capitalize: {
    textTransform: "uppercase",
  },
  smallFont: {
    fontSize: "22px",
  }
});

const TypographyComponent = (props) => {
  const classes = useStyles();

  const classList = [classes.root];

  if (props.mode) {
    const modes = props.mode.split(" ");

    modes.forEach((mode) => {
      classList.push(classes[mode]);
    });
  }

  const className = classList.join(" ");

  return <Typography className={className}>{props.children}</Typography>;
};

export default TypographyComponent;
