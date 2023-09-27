import React from "core-js/library/fn/reflect/es7/metadata";
import { Button } from "@material-ui/core";
import { ThemeProvider, createMuiTheme } from "@material-ui/core/styles";

const theme = createMuiTheme({
  palette: {
    primary: {
      main: "#cccccc",
    },
  },
});

function MaterialUiButton(props) {
  const { variant='primary',children,...rest} = props
  return (
    <Button variant="contained" color="primary">
    Primary
  </Button>
  );
}

export default MaterialUiButton;