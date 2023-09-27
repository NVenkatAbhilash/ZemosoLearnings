import React, { Component } from "react";
import { connect } from "react-redux";
import CounterControl from "../../components/CounterControl/CounterControl";
import CounterOutput from "../../components/CounterOutput/CounterOutput";
import * as actionTypes from "../../store/actions";
import { incrementCount } from "./countService";

class Counter extends Component {
  render() {
    return (
      <div>
        <CounterOutput value={this.props.ctr} />
        <CounterControl
          label="Increment"
          clicked={this.props.onIncrementCounter}
        />
        <CounterControl
          label="Decrement"
          clicked={this.props.onDecrementCounter}
        />
        <CounterControl label="Add 5" clicked={this.props.onIncrementValue} />
        <CounterControl
          label="Subtract 5"
          clicked={this.props.onDecrementValue}
        />
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    ctr: state.counter,
  };
};

const incrementAction = () => async (dispatch, getState) => {
  //can implement logging
  await incrementCount();
  dispatch({ type: actionTypes.INCREMENT });
};

const decrementAction = () => async (dispatch, getState) => {
  await incrementCount();
  dispatch({ type: actionTypes.DECREMENT });
};

/*
const mapDispatchToProps = (dispatch) => {
  return {
    onIncrementCounter: () => incrementAction(),
    onDecrementCounter: () => dispatch({ type: actionTypes.DECREMENT }),
    onIncrementValue: () =>
      dispatch({ type: actionTypes.INCREMENT_VAL, value: 5 }),
    onDecrementValue: () =>
      dispatch({ type: actionTypes.DECREMENT_VAL, value: 5 }),
  };
};
*/

const mapDispatchToProps = {
  onIncrementCounter: incrementAction,
  onDecrementCounter: decrementAction,
  onIncrementValue: () => ({ type: actionTypes.INCREMENT_VAL, value: 5 }),
  onDecrementValue: () => ({ type: actionTypes.DECREMENT_VAL, value: 5 }),
};

export default connect(mapStateToProps, mapDispatchToProps)(Counter);
