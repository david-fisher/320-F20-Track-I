import React from 'react';
import {BrowserRouter as Router,Switch,Route,Redirect} from "react-router-dom";
import Login from "../LoginPage/Login"
import Introduction from '../Introduction/Introduction';

function App() {

  //temporary, the logic below could be useful later
  let loggedIn = false

  return (
    <Router>
      <Switch>
        <Route exact path="/">
          {loggedIn ? <Redirect to="/introduction" /> : <Redirect to="/login"/>}
        </Route>
        <Route path="/login" component={Login} />
        <Route path="/introduction" component={Introduction} />
      </Switch>   
    </Router>
  );
}

export default App;
