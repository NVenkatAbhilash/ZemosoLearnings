import React from "react";
import LoginContainer from "./LoginContainer";

export default {
    title: "organisms/LoginContainer",
    component: LoginContainer,
}


const Template = ({...args})=>(
    <LoginContainer {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
