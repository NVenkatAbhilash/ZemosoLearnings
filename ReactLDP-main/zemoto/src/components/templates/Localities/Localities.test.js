import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import Localities from "./Localities";
import renderer from "react-test-renderer";

it("renders Localities snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <Localities />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders Localities without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <Localities />
    </BrowserRouter>,
    div
  );
});
