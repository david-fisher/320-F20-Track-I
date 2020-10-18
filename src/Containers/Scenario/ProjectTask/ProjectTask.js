import React, {useContext, useEffect} from 'react';
import { Row, Col, Typography, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import {SidebarContext} from "../../../component/SidebarContext"


const ProjectTask = () => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title, Paragraph, Text } = Typography;

  let history = useHistory();

  const handleClick = () => {

    let newSidebarState = state

    if (newSidebarState["projectTask"].routeTo === "initial-reflection")
      history.push("/scenario/initial-reflection")
    else if (newSidebarState["projectTask"].routeTo === "initial-action")
      history.push("/scenario/initial-action")
    else if (newSidebarState["projectTask"].routeTo === "gather-information")
      history.push("/scenario/gather-information")

  }

  useEffect(() => {
    let newSidebarState = state
    newSidebarState["projectTask"].clickable = true
    update({newSidebarState})
  }, [])

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
          <Col offset={5}><Button type="primary" htmlType="submit" onClick={handleClick}>Next Page</Button></Col>
      </Row>
    </>
  );
}
export default ProjectTask;