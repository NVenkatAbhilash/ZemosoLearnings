import React from "react";
import Collections from "./Collections";

export default {
    title: "template/Collections",
    component: Collections,
}


const Template = ({...args})=>(
    <Collections {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}

