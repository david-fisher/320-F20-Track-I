import React, { useContext, useEffect } from 'react';
import { Row, Col, Card, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import './ScenarioIntro.css';
import {SidebarContext} from "../../../component/SidebarContext"
import * as AiIcons from 'react-icons/ai';


const ScenarioIntro = () => {
  
  const {state,update} = useContext(SidebarContext)
  let history = useHistory();

  const handleClick = () => {

    history.push("/scenario/project-task")
    update({0: {
      title: 'Introduction',
      path: '/scenario',
      icon: <AiIcons.AiFillHome />,
      clickable: true
    }})

  }

  return (
    <>
      <Navbar data={state} />
      <Row gutter={16}>
          <ul className="scenarioIntro-headermargin"> </ul>
          <Card bordered={false} style={{textAlign:"center", fontSize:26}}> 
            <p>
              Scenario Introduction:
            </p>
          </Card>
      </Row>

      <Row justify="center" style={{ marginBottom: "30px" }}>
          <Card style={{textAlign:"left", fontSize:16,width:"50rem",height:"45rem",background:"#ECECEC"}}> 
            <p>
            My Medical Advisor is a well-established website that fields millions of queries about diseases, 
            symptoms, and so forth from their registered users.
            For each query, the system provides information, as well as suggestions for relevant 
            healthcare providers and products such as medical equipment and medications.
            </p>

            <p>              
            MMA, Inc., the company developing and running this website, ahs developed Machine Learning (ML) models to
            identify patterns in the query streams coming from their different users. In particular, they have a preliminary
            model that can identify users who are concerned about cognitive decline--that is, trouble remembering, learning
            new things, concentrating, or making decisions that affect everyday life.
            </p>

            <p>
            MMA plans to use its data and models to create lists of users most concerned about cognitive decline, both 
            caregivers and actual sufferers, and then sell those lists to advertisers of pertinent products and services. 
            In this way, MMA can create a new line of business, and also aid its users in navigating the healthcare market, 
            helping them choose from among the ever-increasing number of providers and products so that they won't feel
            overwhelmed or confused.
            </p>

            <p>
            MMA would like to go further and provide these lists to the Department of Motor Vehicles (DMV), for the DMV's
            use in the attempting to proactively remove from these roadways people whose cognitive decline has made them
            unsafe drivers. Those on one of these lists will be required to provide frequent medical certification of 
            their fitness to drive.
            </p>

            <p>
            Before trusting these lists, however, the DMV wants greater assurance of their accuracy. MMA has therefore
            embarked upon a new project aimed at sharpening the existing ML model by analyzing: 1) additional MMA
            site-usage data, such as typing speed, typing accuracy, and repetitive requests, 2) data such as posts, videos,
            and photographs that have been scraped from the social media sites, and 3) data from other sites, such as 
            loyalty sites, that may be accessible.
            </p>

            <p>            
            You have been hired by the company as a junior data scientist and have been assigned to the project.
            </p>
          
          </Card>
      </Row>
      <Row>
          <Col offset={17}><div></div></Col>
          <Col><Button type="primary" htmlType="submit" onClick={handleClick}>next</Button></Col>
      </Row>
    </>
  );
}
export default ScenarioIntro;