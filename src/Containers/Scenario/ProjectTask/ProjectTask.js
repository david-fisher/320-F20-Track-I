import React from 'react';
import { Row, Col, Button } from 'antd';
import { useHistory } from "react-router-dom";


const ProjectTask = () => {
  
  let history = useHistory();

  return (
    <Row gutter={16}>
        <Col offset={5}><div>Project Task</div></Col>
    </Row>
  );
}
export default ProjectTask;