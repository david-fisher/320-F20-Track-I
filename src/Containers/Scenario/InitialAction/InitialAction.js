import React, {useState,useEffect} from 'react';
import { Row, Col, Typography, Button, Radio } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'

const InitialAction = (props) => {
  
  const { Title, Paragraph, Text } = Typography;

  const [choice,setChoice] = useState(0)

  let history = useHistory();

  useEffect(() => {
    console.log("Choice: ",choice)
  },[choice])

  return (
    <>
      <Navbar data={props.data} />
      <Row>
        <Col offset={5} span={18}>
            <Title style={{color: "black"}}>Choose Initial Action</Title>
            <Paragraph>You're a new employee working on a data science team that is working on a larger project. 
              You've also had an oportunity to reflect on your understanding of the task that you have been assigned 
              on this project and to list any questions that still remain for you.
            </Paragraph>
            <Text strong style={{marginTop: "15px"}}>Please select what you would like to do next.</Text>
        </Col>
      </Row>

      <Row>
        <Col offset={5}>
          <Radio.Group onChange={e => setChoice(e.target.value)} value={choice}>
            <Radio value={0}>Would you get to work so that you don't feel stressed about completing your task assignment before the project deadline</Radio><br/>
            <Radio value={1}>Would you delay getting started and try to get answers for any lingering questions that you might have about the project</Radio>
          </Radio.Group>
        </Col>
      </Row>

      <Row>
          <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={() => {history.push("/scenario/gather-information")}}>Next Page</Button></Col>
      </Row>

    </>
  );
}
export default InitialAction;