// MyButton.stories.js

import React from 'react';

import { MyButton } from './MyButton';

export default{
  title: "MyButton",
  component: MyButton,
};

export const Primary = () => (
  <MyButton>Primary</MyButton>
);