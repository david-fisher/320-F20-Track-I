import React, {useState,useContext,useEffect} from 'react';
import { Row, Col, Typography, Button, Radio } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import axios from "axios"
const InitialAction = () => {
  
  const { Title, Paragraph, Text } = Typography;
  const [choice,setChoice] = useState(0)
  const {state,update} = useContext(SidebarContext)
  let history = useHistory();

  const [iaData,setIaData] = useState("")

  const handleClick = () => {

    axios.post('http://localhost:8080/bt/v1/student/1000/scenario/5000/1/page_id/202/initialaction',
        [choice.toString()]
      )
      .then(response => {
        console.log("SENT",response);
      })
      .catch(error => {
        console.log(error);
      });

    history.push("/scenario/gather-information")

    let newSidebarState = state
    newSidebarState["projectTask"].routeTo = "gather-information"
    update({newSidebarState})

  }

  useEffect(() => {    
    axios.get('http://localhost:8080/student/2/scenario/1/2/initialaction',{
      headers: {
        "Access-Control-Allow-Origin": true
      }
    }).then(resp => {
        console.log("INCOMING!",resp)
        setIaData(resp.data.body)
    })
    .catch(err => {
      console.log("THIS IS THE ERROR",err)
    });
  }, [])





  return (
    <>
      <Row>
        <Col offset={5} span={18}>
            <Title style={{color: "black"}}>{iaData.page_title}</Title>
            <Paragraph>{iaData.text}
            </Paragraph>
            <Text strong style={{marginTop: "15px"}}>Please select what you would like to do next.</Text>
        </Col>
      </Row>

      <Row>
        <Col offset={5}>
          <Radio.Group onChange={e => setChoice(e.target.value)} value={choice}>
            <Radio value={0}>Would you get to work so that you don't feel stressed about completing your task assignment before the project deadline</Radio><br/>
            <Radio value={1}>Would you delay getting started and try to get answers for any lingering questions that you might have about the project</Radio>
          </Radio.Group>
        </Col>
      </Row>

      <Row>
          <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col><Col offset={23}></Col>
      </Row>

    </>
  );
}
export default InitialAction;