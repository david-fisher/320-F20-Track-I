import React, {useContext, useEffect,useState} from 'react';
import { Row, Col, Typography, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from "../../../component/SidebarContext"
import axios from "axios"
const ProjectTask = () => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title, Paragraph, Text } = Typography;

  const [ptaData,setPtaData] = useState("")

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

    axios.get('http://localhost:8080/scenario/2/4/pta',{
      headers: {
        "Access-Control-Allow-Origin": true
      }
    }).then(resp => {
        console.log("INCOMING!",resp)
        setPtaData(resp.data.body)
    })
    .catch(err => {
      console.log("THIS IS THE ERROR",err)
    });

  }, [])

  useEffect(() => {
    console.log(ptaData)
  },[ptaData])

  return (
    <>
      <Row>
        <Col offset={5} span={18}>
            <Title style={{color: "black"}}>{ptaData.page_title}</Title>
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
            <Paragraph>{ptaData.text}</Paragraph>
        </Col>
      </Row>
      <Row>
          <Col offset={5}><Button type="primary" htmlType="submit" onClick={handleClick}>Next Page</Button></Col><Col offset={23}></Col>
      </Row>
    </>
  );
}
export default ProjectTask;