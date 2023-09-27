import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import ViewTypePage from "./ViewTypePage";
import renderer from "react-test-renderer";

it("renders ViewTypePage snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <ViewTypePage />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders ViewTypePage without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <ViewTypePage />
    </BrowserRouter>,
    div
  );
});
