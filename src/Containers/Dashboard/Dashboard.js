import React from 'react';
import './dashboard.css';
import Navbar from '../../component/dashboarditems/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Classes from './pages/Classes';
import Results from './pages/Results';
import Support from './pages/Support';

function App() {
    return (
      <>
        <Router>
          <Navbar />
          <Switch>
            <Route path='/classes' component={Classes} />    {/*I want this to be the first page to show, but it aint working. Will look at later -jeef */}
            <Route path='/results' component={Results} />               
            <Route path='/support' component={Support} />
          </Switch>
        </Router>
      </>
    );
  }
  
  export default App;