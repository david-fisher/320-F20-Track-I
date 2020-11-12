import React, {useContext, useEffect, useState} from 'react';
import { Row, Col, Typography, Button, Layout, Progress } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from "../../../component/SidebarContext"
import Stakeholder from "./Stakeholder"
import ConversationsAlreadyHad from"./ConversationsAlreadyHad"


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

  const handleClick = () => {

    let newSidebarState = state

    if (newSidebarState["conversations"].routeTo === "conversation-reflection")
      history.push("/scenario/conversation-reflection")
    else if (newSidebarState["conversations"].routeTo === "final-action")
      history.push("/scenario/final-action")
    else if (newSidebarState["conversations"].routeTo === "summary")
      history.push("/scenario/summary")

  }


  return (
        <Layout>
            <Layout style={{backgroundColor: "white"}}>
                <Row>
                    <Col span={12} offset={6}>
                        <Title>Conversations</Title>
                        <Title level={3}>Please Choose {props.maxConvo} Conversations</Title>
                    </Col>
                </Row>
                {props.stakeholders.map((stakeholder,index) => {
                    return(
                        <Stakeholder
                            key={index}
                            index={index}
                            stakeholders={props.stakeholders}
                            setStakeholders={props.setStakeholders} 
                            name={stakeholder.name} 
                            bio={stakeholder.bio} 
                            maxConvo={props.maxConvo}
                            conversation={stakeholder.conversation} 
                            conversationList={props.conversationList} 
                            setConversationList={props.setConversationList}
                        />
                    )
                })}
                <Row>
                    <Col offset={6} span={8}>
                        <Progress percent={Math.round((props.conversationList.length/props.maxConvo) * 100)} status={props.conversationList.length === props.maxConvo ? "" : "active"} />
                        {/* 5 is arbitrary here and will come from backend! */}
                        {props.conversationList.length< props.maxConvo ? 
                            <Button disabled type="primary">Next Page</Button> : 
                            <Button type="primary" onClick={handleClick}>Next Page</Button>
                        }                
                    </Col>
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