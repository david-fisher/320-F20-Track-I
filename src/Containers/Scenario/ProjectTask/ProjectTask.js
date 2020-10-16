import React, {useContext, useEffect} from 'react';
import { Row, Col, Typography, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import {SidebarContext} from "../../../component/SidebarContext"
import * as AiIcons from 'react-icons/ai';


const ProjectTask = () => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title, Paragraph, Text } = Typography;

  let history = useHistory();

  const handleClick = () => {

    state[1].clickable ? history.push("/scenario/gather-information") :

    history.push("/scenario/initial-reflection")
    update({ 1: {
      title: 'Project Task',
      path: '/scenario/project-task',
      icon: <AiIcons.AiFillHome />,
      clickable: true
    }})

  }

  return (
    <>
      <Navbar data={state} />
      <Row>
        <Col offset={5} span={18}>
            <Title style={{color: "black"}}>Project Task</Title>
            <Text strong> 1. This is Task 1</Text><br/>
            <ul style={{marginLeft:"40px"}}>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
            </ul>
            <Text strong> 2. This is Task 2</Text><br/>
            <ul style={{marginLeft:"40px"}}>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
            </ul>
            <Text strong> 3. This is Task 3</Text><br/>
            <ol style={{marginLeft:"40px"}}>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
              <li><Text>this is text</Text></li>
            </ol>
            <br/>
            <Paragraph>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
              Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
              when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
              It has survived not only five centuries, but also the leap into electronic typesetting, 
              remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset 
              sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like 
              Aldus PageMaker including versions of Lorem Ipsum.
          </Paragraph>
        </Col>
      </Row>
      <Row>
          <Col offset={5}><Button type="primary" htmlType="submit" onClick={handleClick}>next</Button></Col>
      </Row>
    </>
  );
}
export default ProjectTask;