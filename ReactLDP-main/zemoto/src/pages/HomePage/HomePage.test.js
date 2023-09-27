import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import HomePage from "./HomePage";
import renderer from "react-test-renderer";

it("renders HomePage snapshot correctly", () => {
    const location = {
        hash: false,
        search: "something",
      };

  const tree = renderer
    .create(
      <BrowserRouter>
        <HomePage location={location}/>
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders HomePage without crashing", () => {
    const location = {
        hash: false,
        search: "something",
      };

  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <HomePage location={location}/>
    </BrowserRouter>,
    div
  );
});
