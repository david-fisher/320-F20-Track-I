import React, {useContext,useEffect,useState} from 'react';
import { Row, Col, Typography, Divider, Input, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';

const ConsequencesReflection = () => {

    const { Title, Paragraph, Text } = Typography;
  
    const {state,update} = useContext(SidebarContext)
    const {TextArea} = Input;

    const [answer1,setAnswer1] = useState("")
    const [answer2,setAnswer2] = useState("")

    let history = useHistory();


    const handleClick = () => {
        history.push("/scenario/conclusion")
    }

    useEffect(() => {
    //   let newSidebarState = state
    //   newSidebarState["conclusion"].clickable = true
    //   update({newSidebarState})
    }, [])
  
    return (
      <>
          <Row>
            <Col offset={5} span={18}>
                <Title style={{color: "black"}}>Consequences Reflection</Title>
                <Paragraph>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
                    when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
                    It has survived not only five centuries, but also the leap into electronic typesetting, 
                    remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset 
                    sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like 
                    Aldus PageMaker including versions of Lorem Ipsum.<br/><br/>
                </Paragraph>
                <Text strong> 1. Consequence Question 1.</Text><br/>
                <TextArea rows={4} onChange={e => setAnswer1(e.target.value)}/>
                <Text strong> 2. Consequence Question 2.</Text><br/>
                <TextArea rows={4} onChange={e => setAnswer2(e.target.value)}/>
            </Col>
          </Row>
          <Row>
            <Col offset={5}><Button type="primary" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col>
          </Row>
      </>
    );
  }
  export default ConsequencesReflection;