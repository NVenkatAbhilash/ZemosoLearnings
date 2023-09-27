import React, { useState } from "react";
import Temperature from "../Temperature/Temperature";

function Calculator(props) {
  const [temperature, setTemperature] = useState({
    temperature: {
      state: "c",
      value: "0",
    },
  });

  const changeFarenheit = (event) => {
    const temperature = {
      state: "f",
      value: event.target.value,
    };
    setTemperature({
      temperature: temperature,
    });
  };

  const changeCelsius = (event) => {
    const temperature = {
      state: "c",
      value: event.target.value,
    };
    setTemperature({
      temperature: temperature,
    });
  };

  const value = temperature.temperature.value;
  const celsiusValue = temperature.temperature.state==='c'?value:(value-32)*5/9;
  const farenheitValue = temperature.temperature.state==='f'?value:(value*9/5)+32;
  

  return (
    <div>
      <Temperature value={celsiusValue} changeHandler={changeCelsius} />
      <Temperature value={farenheitValue} changeHandler={changeFarenheit} />
    </div>
  );

  /*
    state = {
        temperature:{
            state:'c',
            value:'0'
        }
    }

    changeFarenheit = (event) => {
        const temperature = {
            state:'f',
            value:event.target.value
        }
        this.setState(
            {
                temperature: temperature
            }
        )
    }

    changeCelsius = (event) => {
        const temperature = {
            state:'c',
            value:event.target.value
        }
        this.setState(
            {
                temperature: temperature
            }
        )
    }
    
    render(){
        const value = this.state.temperature.value;
        const celsiusValue = this.state.temperature.state==='c'?value:(value-32)*5/9;
        const farenheitValue = this.state.temperature.state==='f'?value:(value*9/5)+32;
        return (
            <div>
                <Temperature value={celsiusValue} changeHandler={this.changeCelsius} />
                <Temperature value={farenheitValue} changeHandler={this.changeFarenheit} />
            </div>
        );
    }
    */
}

export default Calculator;
