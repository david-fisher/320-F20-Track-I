import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import { IconContext } from 'react-icons';


const Navbar = (props) => {
  

  //Data for navbar should be taken in as a prop

  return (
    <>
      <IconContext.Provider value={{ color: '#fff' }}>
        
        <nav className = 'nav-menu active'>
          <ul className='nav-menu-items'>
            {props.data.map((item, index) => {
              return (
                <li key={index} className={item.cName}>
                  <Link to={item.path}>
                    {item.icon}&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      
                    <span>{item.title}</span>
                  </Link>
                </li>
              );
            })}
          </ul>
        </nav>
      </IconContext.Provider>
    </>
  );
}

export default Navbar;