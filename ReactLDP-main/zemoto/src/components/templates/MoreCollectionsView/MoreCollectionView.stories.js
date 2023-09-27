import React from "react";
import MoreCollectionView from "./MoreCollectionView";

export default {
    title: "template/MoreCollectionView",
    component: MoreCollectionView,
}


const Template = ({...args})=>(
    <MoreCollectionView {...args} />
);


export const Primary = Template.bind({});
Primary.args = {
}
