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

    axios.get('http://localhost:8080/scenario/2/4/gi',{
      headers: {
        "Access-Control-Allow-Origin": true
      }
    }).then(resp => {
        console.log("INCOMING!",resp)
        setGiData(resp.data.body)
    })
    .catch(err => {
      console.log("THIS IS THE ERROR",err)
    });
  }, [])

  useEffect(() => {
    console.log(giData)
  },[giData])


  return (
    <>
        <Row>
          <Col offset={5} span={18}>
              <Title style={{color: "black"}}>{giData.page_title}</Title>
              <Paragraph>{giData.text}<br/><br/>
                  <Text strong>Make your selection on the next screen.</Text>
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