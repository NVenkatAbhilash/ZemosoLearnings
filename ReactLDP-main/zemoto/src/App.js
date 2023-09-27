import { Route, Redirect } from "react-router";
import "./App.css";
import CollectionsPage from "./pages/CollectionsPage/CollectionsPage";
import HomePage from "./pages/HomePage/HomePage";
import ViewTypePage from "./pages/ViewTypePage/ViewTypePage";
//import food from "./resources/images/collection2.jpg";

import auth from './auth/initAuth';
import React from 'react';

const PrivateRoute = ({ component, ...rest }) => (
  <Route {...rest} render={props => (
    auth.loggedIn() ? (
      React.createElement(component, props)
    ) : (
      <Redirect to="/?login" />
    )
  )}/>
)


function App() {
  return (
    <div className="App">
     
      <Route exact path="/" component={HomePage} />
      <PrivateRoute
        exact
        path="/viewType/delivery"
        component={() => <ViewTypePage active={0} />}
      />
      <PrivateRoute
        exact
        path="/viewType/dineOut"
        component={() => <ViewTypePage active={1} />}
      />
      <PrivateRoute
        exact
        path="/viewType/nightLife"
        component={() => <ViewTypePage active={2} />}
      />
      <PrivateRoute
        exact
        path="/collections"
        component={(props) => <CollectionsPage {...props.location.state}/>}
      />
      
    </div>
  );
}

export default App;
