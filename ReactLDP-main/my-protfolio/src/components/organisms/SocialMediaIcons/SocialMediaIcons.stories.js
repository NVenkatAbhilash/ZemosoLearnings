import React from "react";
import SocialMediaIcons from "./SocialMediaIcons";

export default {
  title: "organisms/SocialMediaIcons",
  component: SocialMediaIcons,
};

const Template = ({ children, ...args }) => <SocialMediaIcons {...args} />;

export const photo = Template.bind({});
photo.args = {};
