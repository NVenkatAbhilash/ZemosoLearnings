import React from "react";
import SetLocation from "./setLocation";

export default {
    title: "organisms/setLocation",
    component: SetLocation,
}


const Template = ({...args})=>(
    <SetLocation {...args} />
);


export const Primary = Template.bind({});

export const Shadow = Template.bind({});
Shadow.args = {
    shadowBorder :true,
}
