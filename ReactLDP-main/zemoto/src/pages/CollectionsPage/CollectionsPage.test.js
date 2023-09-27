import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import CollectionsPage from "./CollectionsPage";
import renderer from "react-test-renderer";

it("renders CollectionsPage snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <CollectionsPage />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders CollectionsPage without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <CollectionsPage />
    </BrowserRouter>,
    div
  );
});
