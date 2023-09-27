import React from "react";
import ViewTypeHeader from "./ViewTypeHeader";

export default {
    title: "template/ViewTypeHeader",
    component: ViewTypeHeader,
}


const Template = ({...args})=>(
    <ViewTypeHeader {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}

