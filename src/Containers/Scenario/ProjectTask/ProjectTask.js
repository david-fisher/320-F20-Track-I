import React, {useContext, useEffect} from 'react';
import { Row, Col, Typography, Button, Card } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from "../../../component/SidebarContext"
import HelpMenu from '../../../Containers/Scenario/Conversations/helpMenu';

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
      <Row>
        
        <Col offset={5} span={18}>
        <Card style={{textAlign:"left", fontSize:16,width:"50rem",height:"50rem",background:"#ECECEC"}}> 
            <Title style={{color: "black"}}>Project Task</Title>
            <Text>We want to scape data from out own website and from outside sources to sharpen our predictive 
            ML model for cognitive decline. The data scarping
            tool might colect the following additional data for potentail new features of the model:</Text>
            <br/>
            <Text strong> 1. My Medical Advisor website user interactions</Text><br/>
            <ul style={{marginLeft:"40px"}}>
              <li><Text>Typing speed</Text></li>
              <li><Text>Spelling erros</Text></li>
              <li><Text>Rate of Typing errors</Text></li>
              <li><Text>Incidence of repetitive requests</Text></li>
              <li><Text>Reading speed</Text></li>
            </ul>
            <Text strong> 2. Users' social media content</Text><br/>
            <ul style={{marginLeft:"40px"}}>
              <li><Text>Posts by and about the user</Text></li>
              <li><Text>Pictures and videos</Text></li>
              <li><Text>Relationships: Family, significant other, friends</Text></li>
              <li><Text>Hobbies, exercise, and other activities</Text></li>
            </ul>
            <Text strong> 3. Premiums and memberships</Text><br/>
            <ul style={{marginLeft:"40px"}}>
              <li><Text>Loyaly card purchases</Text></li>
              <li><Text>Browser histories</Text></li>
              <li><Text>Email</Text></li>
            </ul>
            <br/>
            <Paragraph>Part of your assignment is to identify specific companies who would be willing to provide data and also
            make recommendations for further data to collect, in order to refine the above list. Once the data is in hand,
            you will use it to improve the existing predictive model for cognitive decline, by incorporating new training
            features as appropriate.
            
          </Paragraph>
          <Button type="primary" htmlType="submit" onClick={handleClick}>Next Page</Button>
          <Col offset={23}><HelpMenu/></Col>
          </Card>
        </Col>
      </Row>
      <Row>
          <Col offset={5}></Col>
      </Row>
    </>
  );
}
export default ProjectTask;