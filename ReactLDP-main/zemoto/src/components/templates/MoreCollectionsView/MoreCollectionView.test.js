import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import MoreCollectionView from "./MoreCollectionView";
import renderer from "react-test-renderer";

it("renders MoreCollectionView snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <MoreCollectionView />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders MoreCollectionView without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <MoreCollectionView />
    </BrowserRouter>,
    div
  );
});
