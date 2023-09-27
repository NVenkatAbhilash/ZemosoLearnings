import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import SetLocation from "./setLocation";
import renderer from "react-test-renderer";

it("renders SetLocation snapshot correctly", () => {
  const tree = renderer.create(<SetLocation />).toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders SetLocation without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<SetLocation />, div);
});

it("renders SetLocation without crashing 2", () => {
  const div = document.createElement("div");
  ReactDOM.render(<SetLocation shadowBorder />, div);
});
