import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import SignupPage from "./SignupPage";
import renderer from "react-test-renderer";

it("renders SignupPage snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <SignupPage />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders SignupPage without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <SignupPage />
    </BrowserRouter>,
    div
  );
});
