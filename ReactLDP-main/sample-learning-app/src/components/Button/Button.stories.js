import React from "react";
import Button from "./Button";
import Center from "../Center/Center";
import { createMuiTheme,ThemeProvider } from "@material-ui/core/styles";

export default {
  title: "Button",
  component: Button,
  //this applies for all stories within this file
  //decorators: [(story) => <Center>{story()}</Center>],
  args: {
    children: "Button",
  },
  // add addons for control and action
  argTypes: {
    variant: { control: "text" },
    onClick: { action: "clicked" },
  },
};

const theme = createMuiTheme({
  button: {
    primary: {
      main: "#cccccc",
      color: "#000000",
      borderRadius: "50px"
    },
    secondary: {
      main: "#cccccc",
    },
  },
});

//Center is a decorator - it wraps the content
export const Primary = () => (
  <ThemeProvider theme={theme}>
    <Center>
      <Button variant="primary">Primary</Button>
    </Center>
  </ThemeProvider>
);
export const Secondary = () => <Button variant="secondary">Secondary</Button>;
export const Success = () => <Button variant="success">Success</Button>;
export const Danger = () => <Button variant="danger">Danger</Button>;

const Template = (args) => <Button {...args} />;

//args mechanism
export const SmallPrimary = Template.bind({});
SmallPrimary.args = {
  variant: "primary small",
  //children: 'small primary'
};

export const Log = () => (
  <Button variant="primary" onClick={() => console.log("clicked")}>
    Log
  </Button>
);
