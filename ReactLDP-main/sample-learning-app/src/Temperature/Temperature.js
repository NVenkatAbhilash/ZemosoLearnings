import { render } from "@testing-library/react";
import React from "react";

function temperature(props) {
  return (
    <div>
      <p>Temperature</p>
      <input value={props.value} onChange={props.changeHandler} />
    </div>
  );
}

export default temperature;
