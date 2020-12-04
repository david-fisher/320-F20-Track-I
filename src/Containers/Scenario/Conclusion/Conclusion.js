import React, {useContext,useEffect} from 'react';
import { Row, Col, Typography, Divider, Input, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';

const Conclusion = () => {

    const { Title, Paragraph, Text } = Typography;
  
    const {state,update} = useContext(SidebarContext)
    const {TextArea} = Input;


    useEffect(() => {
      // let newSidebarState = state
      // newSidebarState["conclusion"].clickable = true
      // update({newSidebarState})
    }, [])

    const history = useHistory()
  
    return (
      <>
          <Row>
            <Col offset={5} span={18}>
                <Title style={{color: "black"}}>Conclusion</Title>
                <Paragraph>Thank you for completing the Umass Amherst ethics simulation.<br/><br/>
                </Paragraph>
                <Divider />
                <Paragraph>If you would like to sign up for a focus group send an email to ethics-project@cs.umass.edu<br/><br/>
                <Text strong>We would appreciate receiving any comments that you have on this online ethics simulation:</Text>
                </Paragraph>
                <TextArea />
            </Col>
          </Row>    
          <Row>
                <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={() => history.push("/dashboard")}>Submit</Button></Col>
            </Row>
      </>
    );
  }
  export default Conclusion;