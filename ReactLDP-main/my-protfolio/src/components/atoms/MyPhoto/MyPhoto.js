import React from "react";
import myPhoto from "../../../images/my-photo.jpg";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles({
  root: {
    height: "200px",
    borderRadius: "50%",
    objectFit: "cover",
    width: "200px",
  },
  small: {
    height: "100px",
    width: "100px",
  },
});

const MyPhoto = (props) => {
  const classes = useStyles();

    const classList = [classes.root]

    if(props.small){
        classList.push(classes.small);
    }

  const className = classList.join(" ");

  return <img className={className} src={myPhoto} />;
};

export default MyPhoto;
