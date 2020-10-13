import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";
import * as AiIcons from 'react-icons/ai';
import Navbar from '../../../component/dashboarditems/Navbar'



const ProjectTask = (props) => {
  
  let history = useHistory();

  return (
    <>
    <Navbar data={props.data} />
    <Row gutter={16}>
        <Col offset={5}><div>Project Task</div></Col>
        <Col><Button type="primary" htmlType="submit" 
        onClick={() => {
          history.push("/scenario/initial-reflection")
          props.setData(props.data.concat(  {
            title: 'Project Task',
            path: '/scenario/project-task',
            icon: <AiIcons.AiFillHome />
          }))
        }}
          >next</Button></Col>
    </Row>
    </>
  );
}
export default ProjectTask;