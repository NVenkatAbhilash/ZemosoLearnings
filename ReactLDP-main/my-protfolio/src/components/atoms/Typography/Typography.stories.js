import React from "react";
import Typography from "./Typography";

export default {
  title: "atoms/Typography",
  component: Typography,
};

const Template = ({ children, ...args }) => (
    <Typography {...args}>{children}</Typography>
);

export const NormalText = Template.bind({});
NormalText.args = {
  children: "normal text",
};

export const SmallSpaced = Template.bind({});
SmallSpaced.args = {
  children: "small spaced text",
  mode: "smallSpacing",
};

export const Name = Template.bind({});
Name.args = {
  children: "this is my name",
  mode: "largeSpacing capitalize",
};

export const MainHeading = Template.bind({});
MainHeading.args = {
  children: "Heading coloured",
  mode: "heading coloured capitalize"
};
