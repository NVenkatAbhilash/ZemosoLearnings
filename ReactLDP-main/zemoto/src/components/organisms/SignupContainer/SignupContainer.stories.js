import React from "react";
import SignupContainer from "./SignupContainer";

export default {
    title: "organisms/SignupContainer",
    component: SignupContainer,
}


const Template = ({...args})=>(
    <SignupContainer {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
