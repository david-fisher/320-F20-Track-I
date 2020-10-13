import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import * as AiIcons from 'react-icons/ai';


const GatherInformation = (props) => {
  
  let history = useHistory();

  return (
    <>
        <Navbar data={props.data} />
        <Row gutter={16}>
        <Col offset={5}><div>Gather Info</div></Col>
        <Col><Button type="primary" htmlType="submit" 
        onClick={() => {
          history.push("/scenario/gather-information")
          props.setData(props.data.concat(  {
            title: 'Gather Info',
            path: '/scenario/gather-information',
            icon: <AiIcons.AiFillHome />
          }))
        }}
          >next</Button></Col>
    </Row>
    </>
  );
}
export default GatherInformation;