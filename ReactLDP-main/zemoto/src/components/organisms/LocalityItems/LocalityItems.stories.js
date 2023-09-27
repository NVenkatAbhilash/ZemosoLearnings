import React from "react";
import LocalityItems from "./LocalityItems";

export default {
    title: "organisms/LocalityItems",
    component: LocalityItems,
}


const Template = ({...args})=>(
    <LocalityItems {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
