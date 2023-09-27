import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import Restaurant from "./Restaurant";
import renderer from "react-test-renderer";
import collection1 from "./../../../resources/images/collection1.jpg";

it("renders Restaurant snapshot correctly", () => {
  const args = {
    image : collection1,
    name : "Restaurant Name",
    rating : 3.4,
    reviews : "5K",
    foodTypes : ["Hyderabadi", "Chinese", "Biriyani"],
    cost: 150,
    time: 44,
  };

  const tree = renderer.create(<Restaurant {...args} />).toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders Restaurant without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<Restaurant />, div);
});

it("renders Restaurant correctly", () => {
  const args = {
    image : collection1,
    name : "Restaurant Name",
    rating : 3.4,
    reviews : "5K",
    foodTypes : ["Hyderabadi", "Chinese", "Biriyani"],
    cost: 150,
    time: 44,
  };
  const { getByTestId } = render(<Restaurant {...args} />);
  expect(getByTestId("name")).toHaveTextContent(args.name);
  expect(getByTestId('rating')).toHaveTextContent(args.rating);
  expect(getByTestId("reviews")).toHaveTextContent("("+args.reviews+" Delivery Reviews)");
  expect(getByTestId("foodTypes")).toHaveTextContent(args.foodTypes.join(", "));
  expect(getByTestId("costAndTime")).toHaveTextContent("₹"+args.cost+" per person");
  expect(getByTestId("costAndTime")).toHaveTextContent(args.time+" min");  
});
