import React from "react";
import ContactMe from "./ContactMe";

export default {
  title: "templates/ContactMe",
  component: ContactMe,
};

const Template = ({ children, ...args }) => (
    <ContactMe />
);

export const primary = Template.bind({});
primary.args = {
};
