import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import CollectionItems from "./CollectionItems";
import renderer from "react-test-renderer";

it("renders CollectionItems snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <CollectionItems />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders CollectionItems without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <CollectionItems />
    </BrowserRouter>,
    div
  );
});
