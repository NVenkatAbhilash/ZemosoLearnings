import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import MoreCollectionItems from "./MoreCollectionItems";
import renderer from "react-test-renderer";

it("renders MoreCollectionItems snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <MoreCollectionItems />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders MoreCollectionItems without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <MoreCollectionItems />
    </BrowserRouter>,
    div
  );
});
