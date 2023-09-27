import React from "react";
import AboutMe from "./AboutMe";

export default {
  title: "templates/AboutMe",
  component: AboutMe,
};

const Template = ({ children, ...args }) => (
    <AboutMe />
);

export const primary = Template.bind({});
primary.args = {
};
