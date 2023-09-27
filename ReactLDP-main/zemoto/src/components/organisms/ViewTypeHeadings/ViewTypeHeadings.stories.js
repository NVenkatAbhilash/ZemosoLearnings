import React from "react";
import ViewTypeHeadings from "./ViewTypeHeadings";

export default {
    title: "organisms/ViewTypeHeadings",
    component: ViewTypeHeadings,
}


const Template = ({...args})=>(
    <ViewTypeHeadings {...args} />
);


export const Delivery = Template.bind({});
Delivery.args = {
    active: 0,
}

export const DineOut = Template.bind({});
DineOut.args = {
    active: 1,
}

export const Nightlife = Template.bind({});
Nightlife.args = {
    active: 2,
}
