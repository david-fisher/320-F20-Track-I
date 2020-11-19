import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import { IconContext } from 'react-icons';
import { withRouter } from "react-router";
import {Steps} from 'antd';

const Navbar = (props) => {
  

  //Data for navbar should be taken in as a prop
  
  return (
    <>
      <IconContext.Provider value={{ color: '#fff' }}>
        
        <nav className = 'nav-menu active'>
          <ul className='nav-menu-items'>
            {Object.keys(props.data).map((item, index) => {
              return (
                <li key={index} className="nav-text">
                  {props.data[item].clickable ?
                  <Link to={props.data[item].path}>
                    {props.data[item].icon !== null ? props.data[item].icon: null}
                    <span>{props.data[item].title}</span>
                  </Link> 
                  : <div>{props.data[item].title}</div>}
                </li>
              );
            })}
          </ul>
        </nav>
      </IconContext.Provider>
    </>
  );
}

export default withRouter(Navbar);