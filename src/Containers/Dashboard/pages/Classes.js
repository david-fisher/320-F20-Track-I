import React from 'react';
import { Row, Col, Button } from 'antd';
import './Classes.css';
import { useHistory } from "react-router-dom";


function Classes(props) {
  
  let history = useHistory();
  let count = 0;

  //This would be recieved from the backend
  let classesObject = [
    {
      classNumber: "CS320",
      classTitle: "Software Engineering"
    },
    {
      classNumber: "CS311",
      classTitle: "Algorithms"
    },
    {
      classNumber: "CS589",
      classTitle: "Machine Learning"
    },
    {
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty"
    },
    {
      classNumber: "Civ249",
      classTitle: "Introduction to Civil and Environmental Engineering Measurements"
    },
    {
      classNumber: "CS240",
      classTitle: "really loooooooooooooooooooooooo oooooooooooooooooooooooooooooooooog naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaame"
    },
  ]

  return (
    <>
    <div className = "container">
    <Row gutter={10}>
            {classesObject.map((c, index) => {
              
              return(
                // <Col offset={index === 0 ? 0 : 0} key={index}>
                
                <Col offset={1}>
                  <br/>
                  <div className="box" style={{backgroundColor: index % 2 === 0 ? "white" : "white"}} >
                    <div className="head">In Progress...</div> 
                    <div className="class">
                      {c.classNumber + ", "} <br/>
                      
                      <div className='classTitle'>{c.classTitle} 
                        <span className="tooltiptext">{c.classTitle}</span>
                      </div>
                      <br/>
                    </div>
                    

                    <Button className = "start" type="primary" htmlType="submit" onClick={() => history.push("/introduction")}>start</Button>
                  </div>

                  
                </Col>
                
              )
            })}
    </Row>
    </div>
  
      
      
    
      
    </>
  );
}
export default Classes;
