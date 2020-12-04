import React, { useContext, useEffect, useState } from 'react';
import { Row, Col, Card, Button, Typography } from 'antd';
import { useHistory } from "react-router-dom";
import './ScenarioIntro.css';
import {SidebarContext} from "../../../component/SidebarContext"
import axios from "axios"

const ScenarioIntro = () => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title } = Typography;
  let history = useHistory();
  const [introData,setIntroData] = useState("")

  const handleClick = () => {
    history.push("/scenario/project-task")
  }

  useEffect(() => {
    let newSidebarState = state
    newSidebarState["introduction"].clickable = true
    update({newSidebarState})

    axios.get('http://localhost:8080/bt/v1/student/2/scenario/5000/1/introduction'
,{
      headers: {
        "Access-Control-Allow-Origin": true
      }
    }).then(resp => {
        console.log("INCOMING!",resp)
        setIntroData(resp.data.body)
    })
    .catch(err => {
      console.log("THIS IS THE ERROR",err)
    });

  }, [])


  return (
    <>
      <Row>
        <Col offset={5}>
          <Title>{introData.page_title}</Title>
        </Col>
      </Row>
      <Row>
        <Col offset={5}>
      
              {introData.text}<br/>

            <Button type="primary" htmlType="submit" onClick={handleClick}>Next Page</Button><Col offset={23}></Col>
          
        </Col>
      </Row>
    </>
  );
}
export default ScenarioIntro;