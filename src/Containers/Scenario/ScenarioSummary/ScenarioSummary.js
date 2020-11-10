import React, { useContext, useEffect, useState } from 'react';
import { Row, Col, Card, Button, Typography } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from "../../../component/SidebarContext"
import axios from "axios"

const ScenarioSummary = () => {
  
  const {state,update} = useContext(SidebarContext)
  const { Title } = Typography;
  let history = useHistory();

  const [summaryData,setSummaryData] = useState("")

  const handleClick = () => {
    history.push("/scenario/feedback")
  }

  useEffect(() => {
    let newSidebarState = state
    newSidebarState["summary"].clickable = true
    update({newSidebarState})

    axios.get('http://localhost:8080/student/2/scenario/1/2/consequences',{
          headers: {
            "Access-Control-Allow-Origin": true
          }
        }).then(resp => {
            console.log("INCOMING!",resp)
            setSummaryData(resp.data)
        })
        .catch(err => {
          console.log("THIS IS THE ERROR",err)
        });
  }, [])

  useEffect(() => {
    console.log(summaryData)
  },[summaryData])

  return (
    <>
      <Row>
        <Col offset={5}>
          <Title>Scenario Summary</Title>
        </Col>
      </Row>
      <Row>
        <Col offset={5}>
          <Card style={{textAlign:"left", fontSize:15,width:"61vw",background:"#ECECEC"}}> 
            <p>{summaryData.summary_text}</p>
            <p>Summary Point 2</p>
            <p>Summary Point 3</p>
            <Button type="primary" htmlType="submit" onClick={handleClick}>Next Page</Button>
          </Card>
        </Col>
      </Row>
    </>
  );
}
export default ScenarioSummary;