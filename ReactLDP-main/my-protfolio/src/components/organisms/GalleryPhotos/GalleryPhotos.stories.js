import React from "react";
import GalleryPhotos from "./GalleryPhotos";

export default {
  title: "organisms/GalleryPhotos",
  component: GalleryPhotos,
};

const Template = ({ children, ...args }) => <GalleryPhotos {...args} />;

export const photo = Template.bind({});
photo.args = {};
