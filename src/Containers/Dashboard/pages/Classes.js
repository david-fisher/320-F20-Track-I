import React from 'react';
import { Row, Col, Button } from 'antd';
import './Classes.css';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar';


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
      <Navbar data={props.data} />
      <Row gutter={16}>
          {classesObject.map((c, index) => {
            return(
              <Col offset={index === 0 ? 5 : 0} key={index}>
                <div className="box" style={{backgroundColor: index % 2 === 0 ? "#2A9D8F" : "#5b7f95"}}>
                  {c.classNumber} <br/>
                  {c.classTitle}
                  <Button type="primary" htmlType="submit" onClick={() => history.push("/introduction")}>start</Button>
                </div>
              </Col>
            )
          })}
      </Row>
    </>
  );
}
export default Classes;