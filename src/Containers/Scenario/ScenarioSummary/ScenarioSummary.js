import React, { useContext, useEffect, useState } from 'react';
import { Row, Col, Card, Button, Typography } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from "../../../component/SidebarContext"


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
  }, [])



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
            {/* <p>{summaryData.summary_text}</p> */}
            <p>Congratulations you have complete the Umass Amherst Ethics simulation. You can see
              your point coverage of different ethical attributes in the next page.
            </p>
          
            <Button type="primary" htmlType="submit" onClick={handleClick}>Next Page</Button>
          </Card>
        </Col>
      </Row>
    </>
  );
}
export default ScenarioSummary;