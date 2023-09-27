import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import LocalityItems from "./LocalityItems";
import renderer from "react-test-renderer";

it("renders LocalityItems snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <LocalityItems />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders LocalityItems without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <LocalityItems />
    </BrowserRouter>,
    div
  );
});
