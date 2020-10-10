import React from 'react';
import './dashboard.css';
import Navbar from '../../component/dashboarditems/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Classes from './pages/Classes';
import Results from './pages/Results';
import Support from './pages/Support';

const Dashboard = () => {
    return (
      <>
        <Navbar />
        <Switch>
          <Route exact path='/dashboard' component={Classes} />    {/*I want this to be the first page to show, but it aint working. Will look at later -jeef */}
          <Route path='/dashboard/results' component={Results} />               
          <Route path='/dashboard/support' component={Support} />
        </Switch>
      </>
    );
  }
  
  export default Dashboard;