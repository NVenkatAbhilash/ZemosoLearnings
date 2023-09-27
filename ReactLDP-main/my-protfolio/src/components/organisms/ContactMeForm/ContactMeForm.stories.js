import React from "react";
import ContactMeForm from "./ContactMeForm";

export default {
  title: "organisms/ContactMeForm",
  component: ContactMeForm,
};

const Template = ({ children, ...args }) => <ContactMeForm {...args} />;

export const photo = Template.bind({});
photo.args = {};
