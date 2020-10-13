import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'


const InitialRelection = (props) => {
  
  let history = useHistory();

  return (
      <>
    <Navbar data={props.data} />

    <Row gutter={16}>
        <Col offset={5}><div>Initial Relection</div></Col>
        <Col><Button type="primary" htmlType="submit" onClick={() => {history.push("/scenario/initial-action")}}>next</Button></Col>
    </Row>
    </>
  );
}
export default InitialRelection;