import React, {useState, useContext,useEffect} from 'react';
import { Row, Col, Typography, Button, Input } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import axios from "axios"

const ConversationReflection = () => {
  
    const { Title, Paragraph, Text } = Typography;
    const { TextArea } = Input;

    const [answer1,setAnswer1] = useState("")
    const [answer2,setAnswer2] = useState("")
    const [questions,setQuestions] = useState("")

    const {state,update} = useContext(SidebarContext)
    let history = useHistory()

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

        history.push("/scenario/final-action")
    
        let newSidebarState = state
        newSidebarState["conversations"].routeTo = "final-action"
        update({newSidebarState})
    
    }

    useEffect(() => {    
        axios.get('http://localhost:8080/bt/v1/student/1/scenario/5000/1/page_id/205/initialreflection',{
          headers: {
            "Access-Control-Allow-Origin": true
          }
        }).then(resp => {
            console.log("INCOMING!",resp)
            setQuestions(resp.data.body)
        })
        .catch(err => {
          console.log("THIS IS THE ERROR",err)
        });

      }, [])

    return (
        <>
            <Row>
                <Col offset={5} span={18}>
                    <Title style={{color: "black"}}>{'Reflect on Conversations Information'}</Title>
                    
                    {/* <Text strong> {questions[0]}</Text><br/> */}
                    <Text strong> {'What influenced your choices?'}</Text><br/>
                    <TextArea rows={4} onChange={e => setAnswer1(e.target.value)}/>
                    {/* <Text strong> {questions[1]}</Text><br/> */}
                    <Text strong> {'Do you think you took the right course of action?'}</Text><br/>
                    <TextArea rows={4} onChange={e => setAnswer2(e.target.value)}/>
                    

                </Col>
            </Row>
            <Row>
                <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col><Col offset={23}></Col>
            </Row>
        </>
    );
}
export default ConversationReflection;