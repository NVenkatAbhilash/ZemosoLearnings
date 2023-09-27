import React from "react";
import ReactDOM from "react-dom";
import { render, screen, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import CollectionViewItem from "./CollectionViewItem";
import collection1 from "./../../../resources/images/collection2.jpg";
import renderer from 'react-test-renderer';

it('renders CollectionViewItem snapshot correctly', () => {
  const args = {
    special: "What's Special",
    placesCount: 12,
    foodImg: collection1,
  };

  const tree = renderer
    .create(<CollectionViewItem {...args}/>)
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it('renders CollectionViewItem snapshot correctly 2', () => {
  const tree = renderer
    .create(<CollectionViewItem/>)
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders CollectionViewItem without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<CollectionViewItem />, div);
});

it("renders CollectionViewItem correctly", () => {
  const args = {
    special: "What's Special",
    placesCount: 12,
    foodImg: collection1,
  };
  const { getByTestId } = render(<CollectionViewItem {...args}/>);
  expect(getByTestId("special")).toHaveTextContent(args.special);
  expect(getByTestId("place")).toHaveTextContent(args.placesCount+ " Places");
});

it("renders CollectionViewItem correctly when mode='small'", () => {
  const args = {
    special: "What's Special",
    placesCount: 12,
    foodImg: collection1,
  };
  const { getByTestId } = render(<CollectionViewItem mode="small" {...args}/>);
  expect(getByTestId("special")).toHaveTextContent(args.special);
  expect(getByTestId("place")).toHaveTextContent(args.placesCount+ " Places");
});
