import React, {useContext, useEffect, useState} from 'react';
import { Row, Col, Typography, Button, Layout } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from "../../../component/SidebarContext"
import Stakeholder from "./Stakeholder"
import ConversationsAlreadyHad from"./ConversationsAlreadyHad"
import HelpMenu from './helpMenu';


const ConversationsPage = (props) => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title } = Typography;
  const { Sider } = Layout;

  let history = useHistory();

  useEffect(() => {
    let newSidebarState = state
    newSidebarState["conversations"].clickable = true
    update({newSidebarState})
  }, [])

  //from backend
  let stakeholders = [
    {
      name: "Stephen",
      conversation: "this is a conversation with stephen",
      bio: "1 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    },
    {
      name: "Nisarg",
      conversation: "this is a conversation with nisarg",
      bio: "2 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    },
    {
      name: "Jackie",
      conversation: "this is a conversation with jackie",
      bio: "3 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    },
    {
      name: "Jeffrey",
      conversation: "this is a conversation with jefferey",
      bio: "4 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    },
    {
      name:"Dan",
      conversation: "this is a conversation with dan",
      bio:"I am a loserrrr!!!"
    },
    {
        name:"Vy",
        conversation: "this is a conversation with Vy",
        bio:"this is my bio"
    },
    {
        name:"Vani",
        conversation: "this is a conversation with vani",
        bio:"testing testing"
    },
    {
        name:"Sam",
        conversation: "this is a conversation with sam",
        bio:"Hello World!"
    },
    {
        name:"Rachel",
        conversation: "this is a conversation with rachel",
        bio:"I am cool"
    },
      
  ]

  const handleClick = () => {

  }

  return (
        <Layout>
            <Layout style={{backgroundColor: "white"}}>
                <Row>
                    <Col span={12} offset={6}>
                        <Title>Conversations</Title>
                    </Col>
                </Row>
                {stakeholders.map((stakeholder,index) => {
                    return(
                        <Stakeholder
                            key={index} 
                            name={stakeholder.name} 
                            bio={stakeholder.bio} 
                            conversation={stakeholder.conversation} 
                            conversationList={props.conversationList} 
                            setConversationList={props.setConversationList}
                        />
                    )
                })}
                <Row>
                    <Col offset={6}><Button type="primary" onClick={handleClick}>Next Page</Button></Col>
                    <Col offset={22}><HelpMenu/></Col>
                </Row>
            </Layout>
            <Sider theme="light" width="250">
                <Col>
                    <Title level={4}>Conversations had so far</Title>
                    {props.conversationList.map((person,index) => {
                        return(
                            <ConversationsAlreadyHad
                                key={index}
                                name={person.name}
                                conversation={person.conversation}
                            />
                        )
                    })}
                </Col>
            </Sider>
        </Layout>
  );
}
export default ConversationsPage;