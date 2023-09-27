import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import ViewTypeItem from "./ViewTypeItem";
import renderer from "react-test-renderer";

it("renders ViewTypeItem snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <ViewTypeItem />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders ViewTypeItem without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <ViewTypeItem />
    </BrowserRouter>,
    div
  );
});
