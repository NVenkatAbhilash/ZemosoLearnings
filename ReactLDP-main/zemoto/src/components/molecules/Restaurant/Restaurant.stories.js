import React from "react";
import Restaurant from "./Restaurant";
import collection1 from "./../../../resources/images/collection1.jpg";


export default {
  title: "molecules/Restaurant",
  component: Restaurant,
};

const Template = ({ ...args }) => <Restaurant {...args} />;

export const Primary = Template.bind({});
Primary.args = {
    image : collection1,
    name : "Restaurant Name",
    rating : 3.4,
    reviews : "5K",
    foodTypes : ["Hyderabadi", "Chinese", "Biriyani"],
    cost: 150,
    time: 44,
};
