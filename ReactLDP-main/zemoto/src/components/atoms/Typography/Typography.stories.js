import React from "react";
import Typography from "./Typography";

export default {
  title: "atoms/Typography",
  component: Typography,
};

const Template = ({ children, ...args }) => (
    <Typography {...args}>{children}</Typography>
);

export const MainHeading = Template.bind({});
MainHeading.args = {
  children: "Discover the best food & drinks in",
  variant: "h4",
};

export const CityName = Template.bind({});
CityName.args = {
  children: "Hyderabad",
  variant: "h5"
}

export const LogInOrOut = Template.bind({});
LogInOrOut.args = {
  children: "Login",
  variant: "h6"
}

export const AppLink = Template.bind({});
AppLink.args = {
  children: "Get the App",
  variant: "subtitle2",
  mode: "link",
}

export const ViewContent = Template.bind({});
ViewContent.args = {
  children: "Order Food Online",
  variant: "h6"
}