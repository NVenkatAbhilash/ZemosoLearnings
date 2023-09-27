import "./App.css";
import React, { Component } from "react";
import Person from "./Person/Person";
import Reservation from "./Reservation/Reservation";
import Calculator from "./Calculator/Calculator";
import { MyButton } from "./MyButton/MyButton";
//import MaterialUiButton from './components/MaterialUiButton/MaterialUiButton'
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import MyTypography from "./components/MyTypography/MyTypography";
import ClassNames from "./components/StyledButton/StyledButton";
import OtherStyledButton from "./components/StyledButton/OtherStyledButton";
import { ThemeProvider } from "@material-ui/core/styles";
import theme from "./theme";
import SampleApp from "./SampleApp/App";
import LearnFilter from "./LearnFilter/LearnFilter";
import Counter from "./containers/Counter/Counter";


class App extends Component {
  state = {
    persons: [
      {
        id: "1vgb",
        name: "Tony Stark",
        age: 40,
      },
      {
        id: "2vhbjn",
        name: "Steve Rogers",
        age: 140,
      },
    ],
    title: "Avengers",
    doDisplay: false,
  };

  avengersAssemble = () => {
    this.setState({
      persons: [
        {
          name: "Iron Man",
          age: 40,
        },
        {
          name: "Captin America",
          age: 140,
        },
      ],
    });
  };

  changeName = (event, theId) => {
    const personIndex = this.state.persons.findIndex((p) => {
      return p.id === theId;
    });

    const person = {
      ...this.state.persons[personIndex],
    };

    person.name = event.target.value;

    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({
      persons: persons,
    });
  };

  changeDisplay = () => {
    const isDisplay = this.state.doDisplay;

    this.setState({
      doDisplay: !isDisplay,
    });
  };

  removeAvenger = (index) => {
    const persons = [...this.state.persons];
    persons.splice(index, 1);
    this.setState({ persons: persons });
  };

  render() {
    //inline styling
    const style = {
      backgroundColor: "green",
      color: "white",
      padding: "10px",
      borderRadius: "5px",
      fontSize: "15px",
      fontWeight: "800",
    };

    let avengers = null;

    if (this.state.doDisplay) {
      avengers = (
        <div>
          {this.state.persons.map((person, index) => {
            return (
              <Person
                name={person.name}
                age={person.age}
                onClick={() => this.removeAvenger(index)}
                key={person.id}
                changed={(event) => this.changeName(event, person.id)}
              />
            );
          })}
        </div>
      );

      style.backgroundColor = "red";
    }

    return (
      <div>
        <div name="learning">
          <Counter />
          <ThemeProvider theme={theme}>
            <div className="App">
              <Reservation />
              <Calculator />
              <h1> Hello Avengers </h1>
              <button onClick={this.changeDisplay} style={style}>
                View/Hide Avengers
              </button>{" "}
              {avengers}
              <MyButton />
              <Button variant="contained" color="primary">
                Primary
              </Button>
              <form noValidate>
                <TextField
                  label="Next appointment"
                  type="datetime-local"
                  defaultValue="2020-12-22T10:30"
                  InputLabelProps={{
                    shrink: true,
                  }}
                />
              </form>
              <MyTypography>h4 text</MyTypography>
              <ClassNames>New</ClassNames>
              <OtherStyledButton>Other styling</OtherStyledButton>
            </div>
          </ThemeProvider>
        </div>
        <div name="implementing">
                <SampleApp />
        </div>
        <LearnFilter />
      </div>
    );
  }
}

export default App;
