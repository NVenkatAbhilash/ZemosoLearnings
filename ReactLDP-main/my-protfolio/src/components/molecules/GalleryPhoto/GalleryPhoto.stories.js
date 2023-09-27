import React from "react";
import GalleryPhoto from "./GalleryPhoto";

import galleryPhoto1 from "../../../images/gallery/photo1.jpg";
export default {
  title: "molecules/GalleryPhoto",
  component: GalleryPhoto,
};

const Template = ({ children, ...args }) => <GalleryPhoto {...args}/>;

export const photo = Template.bind({});
photo.args = {
  picture: galleryPhoto1,
  name: "with friends",
  date: "22/11/2020",
  information: "get together",
};
