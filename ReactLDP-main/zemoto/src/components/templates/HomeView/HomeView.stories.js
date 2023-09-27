import React from "react";
import HomeView from "./HomeView";

export default {
    title: "template/HomeView",
    component: HomeView,
}


const Template = ({...args})=>(
    <HomeView {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}

