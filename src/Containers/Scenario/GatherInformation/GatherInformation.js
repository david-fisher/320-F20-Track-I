import React, {useContext,useEffect,useState} from 'react';
import { Row, Col, Typography, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import axios from "axios"

const GatherInformation = () => {

  const { Title, Paragraph, Text } = Typography;

  const {state,update} = useContext(SidebarContext)
  let history = useHistory();

  const [giData,setGiData] = useState("")

  const handleClick = () => {
    history.push("/scenario/conversations")
  }

  useEffect(() => {
    let newSidebarState = state
    newSidebarState["gatherInformation"].clickable = true
    update({newSidebarState})

    // axios.get('http://localhost:8080/student/2/scenario/2/4/gi',{
    //   headers: {
    //     "Access-Control-Allow-Origin": true
    //   }
    // }).then(resp => {
    //     console.log("INCOMING!",resp)
    //     setGiData(resp.data.body)
    // })
    // .catch(err => {
    //   console.log("THIS IS THE ERROR",err)
    // });
  }, [])




  return (
    <>
        <Row>
          <Col offset={5} span={18}>
              <Title style={{color: "black"}}>{'Instructions'}</Title>
              {/* <Paragraph>{giData.text}<br/><br/> */}
              <Paragraph>
                  <Text>In the next page, you will be choosing stakeholders to talk depending on whatever situation you have been given. 
                  Please choose carefully, once you pick to have a conversation with a stakeholder, you lost a count on how many more stakeholders you can
                  talk to. A limit will be shown above all the stakeholders. There are drop-down arrows to show a biography of the stakeholder. Once a 
                  stakeholder is chosen, their name will appear on the right hand side, you can click the name to see what information you gathered from
                  your conversation.
                  </Text>
              </Paragraph>
          </Col>
        </Row>
        <Row>
          <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col><Col offset={23}></Col>
        </Row>
    </>
  );
}
export default GatherInformation;