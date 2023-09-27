import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import Collections from "./Collections";
import renderer from "react-test-renderer";

it("renders Collections snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <Collections />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders Collections without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <Collections />
    </BrowserRouter>,
    div
  );
});
