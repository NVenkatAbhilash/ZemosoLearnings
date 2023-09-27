import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import RestaurantItems from "./RestaurantItems";
import renderer from "react-test-renderer";

afterEach(cleanup);

it("renders RestaurantItems snapshot correctly", () => {
  const tree = renderer.create(<RestaurantItems />).toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders RestaurantItems without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<RestaurantItems />, div);
});

it("renders RestaurantItems filters correctly", () => {
  const { getByTestId } = render(<RestaurantItems />);
  fireEvent.change(getByTestId("sortBy").querySelector("input"), { target: { value: "rating" } });
  fireEvent.change(getByTestId("sortBy").querySelector("input"), { target: { value: "time" } });
  fireEvent.change(getByTestId("sortBy").querySelector("input"), { target: { value: "cost asc" } });
  fireEvent.change(getByTestId("sortBy").querySelector("input"), { target: { value: "cost dec" } });
  fireEvent.change(getByTestId("ratingFilter").querySelector("input"), { target: { value: `1` } });
  fireEvent.change(getByTestId("costFilter").querySelector("input"), { target: { value: `200` } });
});

