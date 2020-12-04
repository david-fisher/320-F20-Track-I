import React, {useContext,useEffect,useState} from 'react';
import { Row, Col, Typography, Divider, Input, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import axios from "axios"

const ConsequencesReflection = () => {

    const { Title, Paragraph, Text } = Typography;
  
    const {state,update} = useContext(SidebarContext)
    const {TextArea} = Input;

    const [answer1,setAnswer1] = useState("")
    const [answer2,setAnswer2] = useState("")

    let history = useHistory();


    const handleClick = () => {
        axios.post('http://localhost:8080/bt/v1/student/1000/scenario/5000/1/course_id/320/page_id/205/convoreflection',
          [answer1,answer2]
        )
        .then(response => {
          console.log("SENT",response);
        })
        .catch(error => {
          console.log(error);
        });

        history.push("/scenario/conclusion")
    }

    
  
    return (
      <>
          <Row>
            <Col offset={5} span={18}>
                <Title style={{color: "black"}}>Consequences Reflection</Title>
                
                <Text strong> 1. What do you think about your coverage chart?</Text><br/>
                <TextArea rows={4} onChange={e => setAnswer1(e.target.value)}/>
                <Text strong> 2. Do you think the chart accurately represents you?</Text><br/>
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