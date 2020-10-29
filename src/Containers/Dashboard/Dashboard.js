import React from 'react';
import './dashboard.css';
import { Switch, Route } from 'react-router-dom';
import Classes from './pages/Classes';
import Results from './pages/Results';
import Support from './pages/Support';
import { Navbar, NavItem, NavDropdown, MenuItem, Nav } from 'react-bootstrap';


// import { SidebarDataDashboard } from '../../component/dashboarditems/SidebarDataDashboard';
// import Navbar from "../../component/dashboarditems/Navbar"


const Dashboard = () => {
    return (
      <>
        {/* <Navbar data={SidebarDataDashboard} /> */}
        <div className = "sidebar">
          <Navbar variant="dark" expand="sm">
            <Navbar.Brand>UMASS Amherst Eithcs Sim.</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="tabs">
                <Nav.Link href="/dashboard">Classes</Nav.Link>
                <Nav.Link href="/dashboard/results">Results</Nav.Link>
                <Nav.Link href="/dashboard/support">Support</Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
          </div>
        <Switch>
          <Route exact path='/dashboard' component={Classes}/>
          <Route path='/dashboard/results' component={Results}/>
          <Route path='/dashboard/support' component={Support}/>
        </Switch>
        
      </>
    );
  }
  
  export default Dashboard;