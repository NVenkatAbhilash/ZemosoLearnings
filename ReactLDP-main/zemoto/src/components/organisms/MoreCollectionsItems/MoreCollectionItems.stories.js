import React from "react";
import MoreCollectionItems from "./MoreCollectionItems";

export default {
    title: "organisms/MoreCollectionItems",
    component: MoreCollectionItems,
}


const Template = ({...args})=>(
    <MoreCollectionItems {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
