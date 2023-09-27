import React from "react";
import LocalityViewItem from "./LocalityViewItem";

export default {
  title: "molecules/LocalityViewItem",
  component: LocalityViewItem,
};

const Template = ({ ...args }) => <LocalityViewItem {...args} />;

export const Primary = Template.bind({});
Primary.args = {
  placeName: "A Locality",
  placesCount: 363,
};
