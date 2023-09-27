import React from "react";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";


const useStyles = makeStyles({
  link : {
    cursor : "pointer",
  },
});

const TypographyComponent = ({children, variant, ...props}) => {
  const classes = useStyles();

  const classList = [];

  if(props.mode==='link'){
    classList.push(classes.link);
  }

  const className = classList.join(" ");

  return (
    <Typography className={className} variant={variant} {...props}>
      {children}
    </Typography>
  );
};

export default TypographyComponent;
