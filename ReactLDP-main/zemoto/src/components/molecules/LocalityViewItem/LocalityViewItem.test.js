import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import LocalityViewItem from "./LocalityViewItem";
import renderer from "react-test-renderer";

it("renders LocalityViewItem snapshot correctly", () => {
  const args = {
    placeName: "A Locality",
    placesCount: 363,
  };

  const tree = renderer.create(<LocalityViewItem {...args} />).toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders LocalityViewItem without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<LocalityViewItem />, div);
});

it("renders LocalityViewItem correctly", () => {
  const args = {
    placeName: "A Locality",
    placesCount: 363,
  };
  const { getByTestId } = render(<LocalityViewItem {...args} />);
  expect(getByTestId("text")).toHaveTextContent(
    args.placeName + " (" + args.placesCount + " places)"
  );
});
