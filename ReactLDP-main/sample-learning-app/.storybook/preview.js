import React from "react";
import { addDecorator } from "@storybook/react";
import { ThemeProvider } from "@material-ui/core/styles";
import '@storybook/addon-console'

export const parameters = {
  actions: { argTypesRegex: "^on[A-Z].*" },
};
/*
const theme = {
  palette:{
    primary: {
      main: '#cccccc'
    }
  }
};

addDecorator((story) => (
  <ThemeProvider theme={theme}>
    {story()}
  </ThemeProvider>
));
*/
/*  adding global decorator

import React from 'react'
import { addDecorator } from '@storybook/react'
import Center from './src/compennts/Center/Center'

addDecorator(story => <Center>{story()}</Center)
/*

/*
<ThemeProvider theme={theme}>
  {story()}
</ThemeProvider>
*/
