import React from 'react';
import { Row, Col, Typography, Button, Input } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import * as AiIcons from 'react-icons/ai';


const GatherInformation = (props) => {

  const { Title, Paragraph, Text } = Typography;
  let history = useHistory();

  return (
    <>
        <Navbar data={props.data} />

        <Row>
          <Col offset={5} span={18}>
              <Title style={{color: "black"}}>Start to Gather Information</Title>
              <Paragraph>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                  Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
                  when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
                  It has survived not only five centuries, but also the leap into electronic typesetting, 
                  remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset 
                  sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like 
                  Aldus PageMaker including versions of Lorem Ipsum.<br/><br/>
                  <Text strong>Make your selection on the next screen.</Text>
              </Paragraph>
          </Col>
        </Row>
        <Row>
          <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={() => {
          history.push("/scenario/gather-information")
          props.setData(props.data.concat(  {
            title: 'Gather Info',
            path: '/scenario/gather-information',
            icon: <AiIcons.AiFillHome />
          }))
        }}>Next Page</Button></Col>
        </Row>
    </>
  );
}
export default GatherInformation;