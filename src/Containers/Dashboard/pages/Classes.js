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
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty"
    },
    {
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty"
    },
    {
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty"
    },
    {
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty blah blah blahblahvlah lahblahvlah"
    },
    {
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty"
    },
    {
      classNumber: "CS240",
      classTitle: "Reasoning Under Uncertainty"
    }
  ]

  return (
    <>
    <div class = "container">
    <Row gutter={40}>
            {classesObject.map((c, index) => {
              
              return(
                // <Col offset={index === 0 ? 0 : 0} key={index}>
                
                <Col offset={1}>
                  <br/>
                  <div className="box" style={{backgroundColor: index % 2 === 0 ? "white" : "blanchedalmond"}} >
                    <div className="head">In Progress...</div> 
                    {c.classNumber + ", "} <br/>
                    {c.classTitle} <br/>

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