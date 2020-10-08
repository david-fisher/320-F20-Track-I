import React, { useEffect, useState } from 'react';
// import { Row, Col, Form, Input, Button } from 'antd';
import './Classes.css';
import { Form, Button } from 'antd';
import { FormInput } from '../../../component/Input'
import { Route, useHistory } from "react-router-dom";
import Introduction from '../../Introduction/Introduction'


function Classes() {
  
  let history = useHistory();
  
  function handleClick() {
    history.push("/introduction");
  }

  return (
    

    
    <div class="row">
      <div class ="col">
          <div class="box"></div>
      </div>
      <div class ="col">
          <div class="box"></div>
      </div>
      <div class ="col">
          <div class="box">
          CS320 <br></br>
          Software Enginnering
          <Form>
            <Form.Item >
                <Button type="primary" htmlType="submit" onClick={() => history.push("/introduction")}>start</Button>
            </Form.Item>
          </Form>
          {/* <Route exact path="/" component{Introduction} /> */}
          {/* <button type="button" onClick={handleClick}>
            Start
          </button> */}
          </div>
          
      </div>
      <div class ="col">
          <div class="boxDone">
          CS311 <br></br>
            Algorithms
          </div>
      </div>
    </div>
    

    // <div className='classes'>
    //     <div className="notdoneclass">
    //       CS320 <br></br>
    //       <div className="description">
    //         Computer Engineering <br></br>
    //       </div>
    //       <div className="start">
    //         start
    //       </div>
    //     </div>

    //     <div className="doneclass">
    //       CS311 <br></br>
    //       <div className="description">
    //         Algorithms
    //       </div>
    //     </div>
          
        
    // </div>
  );
}
export default Classes;