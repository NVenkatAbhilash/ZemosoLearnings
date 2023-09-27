import React from "react";
import { createMuiTheme } from "@material-ui/core/styles";
import MyTypography from "./MyTypography";

import { grey, cyan, orange } from "@material-ui/core/colors";

import { ThemeProvider } from "@material-ui/core/styles";

const defaultTheme = createMuiTheme();

const baseTheme = createMuiTheme({

  typography: {
    fontSize: 102,
    color: cyan,
    backgroundColor: grey
  },
});

export default {
  title: "MyTypogrphy",
  conponent: MyTypography,
};

export const Primary = () => (
  <ThemeProvider theme={baseTheme}>
    <MyTypography >H4 text</MyTypography>
  </ThemeProvider>
);
