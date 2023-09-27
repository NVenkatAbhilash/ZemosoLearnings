import React from "react";
import ReactDOM from "react-dom";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "@testing-library/jest-dom";
import TextField from "./TextField";

afterEach(cleanup);

it("renders TextField without crashing",()=>{
    const div = document.createElement("div");
    ReactDOM.render(<TextField placeholder="Some text"/>,div);
});


it("renders TextField correctly",()=>{
    const { getByTestId } = render(<TextField placeholder="Some text"/>);
    const textField = getByTestId('textField').querySelector('input');
    expect(textField.value).toEqual('');
});


it("TextField input works correctly",()=>{
    const { getByTestId } = render(<TextField placeholder="Some text"/>);
    const textField = getByTestId('textField').querySelector('input');
    fireEvent.change(textField, {target: {value: "some text"}});
    expect(textField.value).toEqual('some text');
});