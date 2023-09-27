import React from "react";
import Localities from "./Localities";

export default {
    title: "template/Localities",
    component: Localities,
}


const Template = ({...args})=>(
    <Localities {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}

