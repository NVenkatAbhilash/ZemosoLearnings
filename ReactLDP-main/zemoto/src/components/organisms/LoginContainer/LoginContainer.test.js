import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup, getByText } from "@testing-library/react";
import "@testing-library/jest-dom";
import LoginContainer from "./LoginContainer";
import userEvent from "@testing-library/user-event";
import renderer from "react-test-renderer";


afterEach(cleanup);

const mockSetDisplay = jest.fn((x) => x);
const mockSetOtherDisplay = jest.fn((x) => x);

it("renders LoginContainer snapshot correctly", () => {
  const tree = renderer
    .create(
        <LoginContainer />
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders LoginContainer without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<LoginContainer />, div);
});

it("renders LoginContainer correctly with email and password", () => {
  const { getByTestId } = render(<LoginContainer />);
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

it("renders LoginContainer continue with google button", () => {
  const { getByTestId } = render(<LoginContainer />);
  expect(getByTestId("googleLogin")).toBeDefined();
});

it("renders LoginContainer Sign up button", () => {
  const { getByTestId } = render(<LoginContainer setDisplay={mockSetDisplay} setOtherDisplay={mockSetOtherDisplay} />);
  expect(getByTestId("signUp")).toBeDefined();
  fireEvent.click(getByTestId("signUp"));
  expect(mockSetDisplay.mock.calls.length).toBe(1);
  expect(mockSetOtherDisplay.mock.calls.length).toBe(1);
});


it("renders LoginContainer close icon", () => {
  const { getByTestId } = render(<LoginContainer setDisplay={mockSetDisplay} setOtherDisplay={mockSetOtherDisplay} />);
  expect(getByTestId("close")).toBeDefined();
  fireEvent.click(getByTestId("close"));
  expect(mockSetDisplay.mock.calls.length).toBe(1);
});
