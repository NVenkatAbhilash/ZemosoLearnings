import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import HeaderViewItem from "./HeaderViewItem";
import foodImg from "./../../../resources/images/foodItem.jpg";
import renderer from "react-test-renderer";

it("renders HeaderViewItem snapshot correctly", () => {
  const args = {
    children: "Food Item",
    foodImg: foodImg,
  };

  const tree = renderer.create(<HeaderViewItem {...args} />).toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders HeaderViewItem without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<HeaderViewItem />, div);
});

it("renders HeaderViewItem correctly", () => {
  const args = {
    children: "Food Item",
    foodImg: foodImg,
  };
  const { getByTestId } = render(<HeaderViewItem {...args} />);
  expect(getByTestId("text")).toHaveTextContent(args.children);
});
