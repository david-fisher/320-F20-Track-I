import React, {useContext,useEffect} from 'react';
import { Row, Col, Typography, Divider, Input, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';

const Feedback = () => {

    const { Title, Paragraph } = Typography;
  
    const {state,update} = useContext(SidebarContext)

    let history = useHistory();


    const handleClick = () => {
        history.push("/scenario/consequences-reflection")
    }

    useEffect(() => {
      let newSidebarState = state
      newSidebarState["feedback"].clickable = true
      update({newSidebarState})
    }, [])
  
    return (
      <>
          <Row>
            <Col offset={5} span={18}>
                <Title style={{color: "black"}}>Feedback</Title>
                <Title style={{color: "black"}}>There will be a radar plot here soon...</Title>
                <Paragraph>Words about the plot<br/><br/>
                </Paragraph>
                <Divider />
            </Col>
          </Row>
          <Row>
            <Col offset={5}><Button type="primary" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col>
          </Row>
      </>
    );
  }
  export default Feedback;