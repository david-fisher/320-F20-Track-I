import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";
import * as AiIcons from 'react-icons/ai';
import Navbar from '../../../component/dashboarditems/Navbar'

const ScenarioIntro = (props) => {
  
  let history = useHistory();

  return (
    <>
      <Navbar data={props.data} />
      <Row gutter={16}>
          <Col offset={5}><div>Scenario Intro</div></Col>
          <Col><Button type="primary" htmlType="submit" 
          onClick={() => {
            history.push("/scenario/project-task")
            props.setData(props.data.concat(  {
              title: 'Introduction',
              path: '/scenario',
              icon: <AiIcons.AiFillHome />
            }))
          }}
            >next</Button></Col>
      </Row>
    </>
  );
}
export default ScenarioIntro;