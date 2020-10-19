import React from 'react';
import './dashboard.css';
import { Switch, Route } from 'react-router-dom';
import Classes from './pages/Classes';
import Results from './pages/Results';
import Support from './pages/Support';
import { SidebarDataDashboard } from '../../component/dashboarditems/SidebarDataDashboard';
import Navbar from "../../component/dashboarditems/Navbar"


const Dashboard = () => {
    return (
      <>
        <Navbar data={SidebarDataDashboard} />
        <Switch>
          <Route exact path='/dashboard' component={Classes}/>
          <Route path='/dashboard/results' component={Results}/>
          <Route path='/dashboard/support' component={Support}/>
        </Switch>
      </>
    );
  }
  
  export default Dashboard;