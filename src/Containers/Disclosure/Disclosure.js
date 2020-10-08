import React from 'react';
import { Row, Col, Typography, Avatar, Card} from 'antd';
import { ArrowRightOutlined } from '@ant-design/icons';
import {BrowserRouter as Router,Route,Switch,Link,Redirect} from "react-router-dom";

//function component
const Disclosure= () => {

    const { Title, Paragraph } = Typography;
    return (   
            <div className="Disclosure">
            <Row justify="center" style={{ marginBottom: "30px" }}>
                <Col>
                    <div style={{ backgroundColor: "#881C1C", height: "170px", width: "100vw" }}>
                        <Title level={2} style={{ textAlign: "center", lineHeight: "200px", color: "white",fontSize:40 }}>Disclosure</Title>
                    </div>
                </Col>
            </Row>
            <Row justify="start">
            <div style={{ background: '#ECECEC',padding:'30px'}}>
                <Card bodyStyle={{paddingLeft:150,paddingRight:150}} bordered={false} style={{textAlign:"center", width: '1860px', fontSize:26}} > 
                    <p>
                    What about you is being reported to your professor:
                    </p>
                    <p>
                    Your professor will receive a summary report indicating which students have
                    completed the scenario, along with a description of what happened during 
                    the scenario for each student, i.e., the student’s choices and student’s 
                    answers to the questions, as well as answers to any supplemental questions
                    that your professor may add.
                    </p>
                    </Card>
                <Card bodyStyle={{paddingLeft:150,paddingRight:150}} bordered={false} style={{ textAlign:"center", width: '1860px', fontSize:26}} >
                    <p>
                    How we are using your contributions:
                    </p>
                    <p>
                    Any engagement students have within the scenario can be used within the 
                    course to help your professor assess students’ cumulative learning about 
                    ethical decision-making. The developers of the simulation may also use this
                    information for purposes of improvement and further development of the 
                    software. No identifying information about you will be included as a part of 
                    the information that is disclosed in any reports or presentation of results outside of your course.
                    </p>
                </Card>
            </div>
            </Row>
            <ArrowRightOutlined style={{ fontSize: "50px",paddingLeft:1850 }} onClick={() => console.log("triggered")} />
        </div>
    );

}

export default Disclosure
