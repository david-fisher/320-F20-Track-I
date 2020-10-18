import React from 'react';
import './dashboard.css';
import { Switch, Route } from 'react-router-dom';
import Classes from './pages/Classes';
import Results from './pages/Results';
import Support from './pages/Support';
import { SidebarDataDashboard } from '../../component/dashboarditems/SidebarDataDashboard';


const Dashboard = () => {
    return (
      <>
        <Switch>
          <Route exact path='/dashboard'>
            <Classes data={SidebarDataDashboard} />
          </Route>    
          <Route path='/dashboard/results'>
            <Results data={SidebarDataDashboard} />  
          </Route>               
          <Route path='/dashboard/support'>
            <Support data={SidebarDataDashboard} />
          </Route>
        </Switch>
      </>
    );
  }
  
  export default Dashboard;