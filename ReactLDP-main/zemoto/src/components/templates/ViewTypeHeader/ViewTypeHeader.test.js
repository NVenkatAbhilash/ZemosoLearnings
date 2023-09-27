import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import ViewTypeHeader from "./ViewTypeHeader";
import renderer from "react-test-renderer";
import { render, fireEvent, cleanup } from "@testing-library/react";


it("renders ViewTypeHeader snapshot correctly", () => {
  const tree = renderer
    .create(
      <BrowserRouter>
        <ViewTypeHeader />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders ViewTypeHeader without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <ViewTypeHeader />
    </BrowserRouter>,
    div
  );
});

it("renders ViewTypeHeader correctly when Logout clicked", () => {
      const { getByTestId } = render(<BrowserRouter>
        <ViewTypeHeader />
      </BrowserRouter>);
      //expect(getByTestId("logoutLink")).toBeDefined();
      fireEvent.click(getByTestId("logoutLink"));
  });
