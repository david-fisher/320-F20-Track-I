import React from 'react';
import './dashboard.css';
import { Switch, Route } from 'react-router-dom';
import Classes from './pages/Classes';
import { IconContext } from 'react-icons';

import Support from './pages/Support';
import { Navbar, Nav } from 'react-bootstrap';
import * as IoIcons from 'react-icons/io';


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
                <IconContext.Provider value={{ color: '#fff' }}>
                  <Nav.Link href="/dashboard">
                    <IoIcons.IoIosPaper />{' '} Classes 
                    </Nav.Link>

                  {/* <Nav.Link href="/dashboard/results">Results</Nav.Link> */}
                  <Nav.Link href="/dashboard/support"><IoIcons.IoMdHelpCircle />{' '}Support</Nav.Link>
                </IconContext.Provider>
              </Nav>
              <Nav className="justify-content-end" style={{ width: "100%", color: "white" }}>
                <Nav.Link href="/getOuttaHere">
                  Disconnect
                </Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
          </div>
        <Switch>
          <Route exact path='/dashboard' component={Classes}/>
          {/* <Route path='/dashboard/results' component={Results}/> */}
          <Route path='/dashboard/support' component={Support}/>
        </Switch>
        
      </>
    );
  }
  
  export default Dashboard;