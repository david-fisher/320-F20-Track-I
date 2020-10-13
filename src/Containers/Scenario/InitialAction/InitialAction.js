import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'


const InitialAction = (props) => {
  
  let history = useHistory();

  return (
      <>
          <Navbar data={props.data} />

    <Row gutter={16}>
        <Col offset={5}><div>Initial Action</div></Col>
        <Col><Button type="primary" htmlType="submit" onClick={() => {history.push("/scenario/gather-information")}}>next</Button></Col>
    </Row>
    </>
  );
}
export default InitialAction;