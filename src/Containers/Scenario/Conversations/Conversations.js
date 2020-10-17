import React, {useContext, useEffect} from 'react';
import { Row, Col, Typography, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import {SidebarContext} from "../../../component/SidebarContext"
import Stakeholder from "./Stakeholder"


const Conversations = () => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title, Paragraph, Text } = Typography;

  let history = useHistory();

  let stakeholders = [
    {
      name: "Stephen",
      bio: "1 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
      name: "Nisarg",
      bio: "2 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
      name: "Jackie",
      bio: "3 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
      name: "Jeffrey",
      bio: "4 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
        name:"Dan",
        bio:"I am a loserrrr!!!"
    }
  ]

  const handleClick = () => {

  }

  return (
    <>
        <Navbar data={state} />
        <Row justify="center">
            <Title>Conversations</Title>
        </Row>
            {stakeholders.map(stakeholder => {
                return(
                    <Stakeholder name={stakeholder.name} bio={stakeholder.bio} />
                )
            })}
        <Row>
            <Col offset={5}><Button type="primary" htmlType="submit" onClick={handleClick}>next</Button></Col>
        </Row>
    </>
  );
}
export default Conversations;