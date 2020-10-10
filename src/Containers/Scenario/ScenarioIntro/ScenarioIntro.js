import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";


const ScenarioIntro = () => {
  
  let history = useHistory();

  return (
    <Row gutter={16}>
        <Col offset={5}><div>Scenario Intro</div></Col>
        <Col><Button type="primary" htmlType="submit" onClick={() => history.push("/scenario/project-task")}>next</Button></Col>
    </Row>
  );
}
export default ScenarioIntro;