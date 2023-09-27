import React from "react";
import CollectionViewItem from "./CollectionViewItem";
import collection1 from "./../../../resources/images/collection2.jpg";


export default {
  title: "molecules/CollectionViewItem",
  component: CollectionViewItem,
};

const Template = ({ ...args }) => <CollectionViewItem {...args} />;

export const Medium = Template.bind({});
Medium.args = {
  special: "What's Special",
  placesCount: 12,
  foodImg : collection1,
};

export const Small = Template.bind({});
Small.args = {
  special: "What's Special",
  placesCount: 12,
  foodImg : collection1,
  mode: "small",
};
