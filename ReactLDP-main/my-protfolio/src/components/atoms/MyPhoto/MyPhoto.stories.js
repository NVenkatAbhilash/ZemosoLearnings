import React from "react";
import MyPhoto from "./MyPhoto";

export default {
  title: "atoms/MyPhoto",
  component: MyPhoto,
};

const Template = ({ children, ...args }) => (
    <MyPhoto />
);

export const photo = Template.bind({});
photo.args = {
};

export const smallPhoto = Template.bind({});
smallPhoto.args = {
  small: true,
};
