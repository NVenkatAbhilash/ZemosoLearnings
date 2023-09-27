import React from "react";
import ColouredHR from "./ColouredHR";

export default {
  title: "atoms/ColouredHR",
  component: ColouredHR,
};

const Template = ({ children, ...args }) => (
    <ColouredHR />
);

export const hr = Template.bind({});
hr.args = {
};
