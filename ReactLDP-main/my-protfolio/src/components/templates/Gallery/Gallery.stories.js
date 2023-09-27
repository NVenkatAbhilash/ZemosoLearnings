import React from "react";
import Gallery from "./Gallery";

export default {
  title: "templates/Gallery",
  component: Gallery,
};

const Template = ({ children, ...args }) => (
    <Gallery />
);

export const primary = Template.bind({});
primary.args = {
};
