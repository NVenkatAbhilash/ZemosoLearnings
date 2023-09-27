import React from "react";
import Typography from "@material-ui/core/Typography";

const MyTypography = (props) => (
  <Typography variant={props.variant}>
    TEXT: {props.children}
  </Typography>
);

export default MyTypography;