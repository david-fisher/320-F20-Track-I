import React from 'react';
import { Row, Col, Card, Button } from 'antd';
import { useHistory } from "react-router-dom";
import * as AiIcons from 'react-icons/ai';
import Navbar from '../../../component/dashboarditems/Navbar'
import '../ScenarioIntro/ScenarioIntro.css'


const ProjectTask = (props) => {
  
  let history = useHistory();

  return (
    <>
    <Navbar data={props.data} />
    <Navbar data={props.data} />
      <Row gutter={16}>
          <ol className="scenarioIntro-headermargin"> </ol>
          <Card bordered={false} style={{textAlign:"center", fontSize:26}}> 
            <p>
              ProjectTask
            </p>
          </Card>
      </Row>

      <Row justify="center" style={{ marginBottom: "30px" }}>
          <Card style={{textAlign:"left", fontSize:16,width:"50rem",height:"45rem",background:"#ECECEC"}}> 
            <p>
            We want to scape data from out own website and from outside sources to sharpen our predictive ML model for cognitive decline. The data scarping
            tool might colect the following additional data for potentail new features of the model:
            </p>
            <b>1. My Medical Advisor website user interactions</b>
            <p>              
            a. Typing speed <br></br>
            b. Spelling erros <br></br>
            c. Rate of Typing errors <br></br>
            d. Incidence of repetitive requests<br></br>
            e. Reading speed
            </p>
            <b>2. Users' social media content</b>
            <p>
            a. Posts by and about the user <br></br>
            b. Pictures and videos <br></br>
            c. Relationships: Family, significant other, friends <br></br>
            d. Hobbies, exercise, and other activities
            </p>
            <b></b>
            <p>
            a. Loyaly card purchases <br></br>
            b. Browser histories <br></br>
            c. Email
            </p>

            <p>
            Part of your assignment is to identify specific companies who would be willing to provide data and also
            make recommendations for further data to collect, in order to refine the above list. Once the data is in hand,
            you will use it to improve the existing predictive model for cognitive decline, by incorporating new training
            features as appropriate.
            </p>

            <Row>
            <Col offset={21}><div></div></Col>
            <Col><Button type="primary" htmlType="submit" 
            onClick={() => {
              history.push("/scenario/project-task")
              props.setData(props.data.concat(  {
                title: 'Introduction',
                path: '/scenario',
                icon: <AiIcons.AiFillHome />
              }))
            }}
              >next</Button></Col>
          </Row>
          </Card>
      </Row>
      
    </>
  );
}
export default ProjectTask;