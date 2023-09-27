import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import ViewTypeHeadings from "./ViewTypeHeadings";
import renderer from "react-test-renderer";

it("renders ViewTypeHeadings snapshot correctly 1", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <ViewTypeHeadings />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders ViewTypeHeadings snapshot correctly 2", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <ViewTypeHeadings active="1" />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders ViewTypeHeadings snapshot correctly 3", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <ViewTypeHeadings active="2" />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});
it("renders ViewTypeHeadings without crashing 1", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <ViewTypeHeadings />
    </BrowserRouter>,
    div
  );
});

it("renders ViewTypeHeadings without crashing 2", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <ViewTypeHeadings active="2" />
    </BrowserRouter>,
    div
  );
});
