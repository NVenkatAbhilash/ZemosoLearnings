import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import MainCollection from "./MainCollection";
import renderer from "react-test-renderer";

it("renders MainCollection snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <MainCollection />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders MainCollection without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <MainCollection />
    </BrowserRouter>,
    div
  );
});
