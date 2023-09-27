import React from "react";
import RestaurantItems from "./RestaurantItems";

export default {
    title: "organisms/RestaurantItems",
    component: RestaurantItems,
}


const Template = ({...args})=>(
    <RestaurantItems {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
