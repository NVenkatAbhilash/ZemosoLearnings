import React from "react";
import LearnFilter from "./LearnFilter";

export default {
  title: "learn/LearnFilter",
  component: LearnFilter,
};

const Template = ({ ...args }) => <LearnFilter {...args} />;

export const Primary = Template.bind({});
Primary.args = {
};
