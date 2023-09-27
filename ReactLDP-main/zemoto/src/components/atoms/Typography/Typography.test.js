import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import Typography from "./Typography";

it("renders Typography without crashing",()=>{
    const div = document.createElement("div");
    ReactDOM.render(<Typography />,div);
});

it("renders Typography correctly",()=>{
    const {getByTestId,getByText} =render(<Typography>some text</Typography>);
    expect(getByText("some text")).toBeTruthy();
})