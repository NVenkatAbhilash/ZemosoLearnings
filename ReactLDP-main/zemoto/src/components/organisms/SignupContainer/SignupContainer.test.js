import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import SignupContainer from "./SignupContainer";
import userEvent from "@testing-library/user-event";
import renderer from "react-test-renderer";


afterEach(cleanup);


it("renders SignupContainer snapshot correctly", () => {
  const tree = renderer
    .create(
        <SignupContainer />
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders SignupContainer without crashing", () => {
  const div = document.createElement("div");
  const props = {
    setDisplay: () => true,
    setOtherDisplay: () => true,
  };
  ReactDOM.render(<SignupContainer props />, div);
});

it("renders SignupContainer correctly with email and password", () => {
  const props = {
    setDisplay: (something) => something,
    setOtherDisplay: (something) => something,
  };
  const { getByTestId } = render(<SignupContainer props />);
  const email = getByTestId("email").querySelector("input");
  //fireEvent.change(email, { target: { value: "abhilash@gmail.com" } });
  userEvent.type(email, "abhilash@gmail.com");
  expect(email.value).toEqual("abhilash@gmail.com");
  const password = getByTestId("password").querySelector("input");
  //  fireEvent.change(password, { target: { value: "Password123" } });
  userEvent.type(password, "Password123");
  expect(password.value).toEqual("Password123");
  fireEvent.click(getByTestId("button"));
});

it("renders SignupContainer continue with google button", () => {
  const props = {
    setDisplay: (something) => something,
    setOtherDisplay: (something) => something,
  };
  const { getByTestId } = render(<SignupContainer props />);
  expect(getByTestId("googleLogin")).toBeDefined();
});

it("renders SignupContainer Sign up button", () => {
  const props = {
    setDisplay: (something) => something,
    setOtherDisplay: (something) => something,
  };
  const { getByTestId } = render(<SignupContainer props />);
  expect(getByTestId("login")).toBeDefined();
});


const mockSetDisplay = jest.fn((x) => x);
const mockSetOtherDisplay = jest.fn((x) => x);

it("renders SignupContainer Sign up button", () => {
  const { getByTestId } = render(<SignupContainer setDisplay={mockSetDisplay} setOtherDisplay={mockSetOtherDisplay} />);
  expect(getByTestId("login")).toBeDefined();
  fireEvent.click(getByTestId("login"));
  expect(mockSetDisplay.mock.calls.length).toBe(1);
  expect(mockSetOtherDisplay.mock.calls.length).toBe(1);
});


it("renders SignupContainer close icon", () => {
  const { getByTestId } = render(<SignupContainer setDisplay={mockSetDisplay} setOtherDisplay={mockSetOtherDisplay} />);
  expect(getByTestId("close")).toBeDefined();
  fireEvent.click(getByTestId("close"));
  expect(mockSetDisplay.mock.calls.length).toBe(1);
});