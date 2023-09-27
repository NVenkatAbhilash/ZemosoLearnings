import React from "react";
import MainCollection from "./MainCollection";
import foodPhoto from "../../../resources/images/collection2.jpg";

export default {
    title: "template/MainCollection",
    component: MainCollection,
}


const Template = ({...args})=>(
    <MainCollection {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
    foodImg: foodPhoto,
}

