import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import LoginPage from "./LoginPage";
import renderer from "react-test-renderer";

it("renders LoginPage snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <LoginPage />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders LoginPage without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <LoginPage />
    </BrowserRouter>,
    div
  );
});
