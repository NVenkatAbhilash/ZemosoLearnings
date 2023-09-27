import React from "react";
import ViewTypeItem from "./ViewTypeItem";

export default {
    title: "organisms/ViewTypeItem",
    component: ViewTypeItem,
}


const Template = ({...args})=>(
    <ViewTypeItem {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
