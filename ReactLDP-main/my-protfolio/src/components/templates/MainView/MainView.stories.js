import React from "react";
import MainView from "./MainView";

export default {
  title: "templates/MainView",
  component: MainView,
};

const Template = ({ children, ...args }) => (
    <MainView />
);

export const primary = Template.bind({});
primary.args = {
};
