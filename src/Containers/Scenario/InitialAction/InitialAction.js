import React from 'react';
import { Row, Col, Card, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'

const InitialAction = (props) => {
  
  let history = useHistory();

  return (
      <>
          <Navbar data={props.data} />

    <Row gutter={16}>
        <ul className="scenarioIntro-headermargin"> </ul>
          <Card bordered={false} style={{textAlign:"center", fontSize:26}}> 
            <p>
              Choose initial action:
            </p>
          </Card>
    </Row>

    <Row justify="center" style={{ marginBottom: "10px" }}>
      <Card style={{textAlign:"left", fontSize:16,width:"55rem",height:"30rem",background:"#ECECEC" }}> 
      <p>
      You're a new employee working on a data science team that is working on a larger project. You've also had an oportunity to reflect on your understanding of the task that you have been assigned on this project and to list any questions that still remain for you.
      </p>
      <p>
      Please select what you would like to do next
      </p>
      <p>
      Would you:
      </p>
      <Col><Button type="text" htmlType="submit" style={{ fontSize:16}} size = "middle" 
        onClick={() => {
          history.push("/scenario/gather-information")}
          }> <u>get to work so that you don't feel stressed about completing your task assignment before the project deadline</u></Button></Col> 
      <p>
      Or
      </p>
      <Col><Button type="text" htmlType="submit" style={{ fontSize:16}}  size = "small"
        onClick={() => {
          history.push("/scenario/gather-information")}
          }><u>delay getting started and try to get answers for any lingering questions that you might have about the project</u></Button></Col> 
      </Card>
    </Row>

    </>
  );
}
export default InitialAction;