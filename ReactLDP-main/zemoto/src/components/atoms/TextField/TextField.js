import React from "react";
import TextField from "@material-ui/core/TextField";


const TextFieldComponent = (props) => {
  return (
    <TextField
      fullWidth
      InputProps={{ disableUnderline: true }}
      {...props}
      variant="standard"
      data-testid="textField"
    />
  );
};

export default TextFieldComponent;
