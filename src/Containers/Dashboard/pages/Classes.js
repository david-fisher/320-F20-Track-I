import React from 'react';
import { Row, Col, Button } from 'antd';
import './Classes.css';
import { useHistory } from "react-router-dom";


function Classes(props) {
  
  let history = useHistory();

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
    }
  ]

  return (
    <>
    <div class = "container">
    <Row gutter={36}>
            {classesObject.map((c, index) => {
              return(
                <Col offset={index === 0 ? 3 : 0} key={index}>
                  <br/>
                  <div className="box" style={{backgroundColor: index % 2 === 0 ? "blanchedalmond" : "blanchedalmond"}}>
                    <div className="head">In Progress...</div>
                    {c.classNumber + ", "}
                    {c.classTitle} <br/>

                    <Button className = "start" type="primary" htmlType="submit" onClick={() => history.push("/introduction")}>start</Button>
                   
                  </div>
                </Col>
              )
        })}
    </Row>
    </div>
  
      
      {/* <div class="leftpane">
        <h1>What</h1>
        </div>
      <div class="middlepane">
        
        <h1>The</h1>
      </div>
      <div class="rightpane">
        <h1>Fuck</h1>
      </div> */}
    
      
    </>
  );
}
export default Classes;