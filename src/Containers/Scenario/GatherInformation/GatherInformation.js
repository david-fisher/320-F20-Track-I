import React, {useContext} from 'react';
import { Row, Col, Typography, Button, Input } from 'antd';
import { useHistory } from "react-router-dom";
import Navbar from '../../../component/dashboarditems/Navbar'
import SidebarContext from '../../../component/SidebarContext';



const GatherInformation = () => {

  const { Title, Paragraph, Text } = Typography;

  const sidebarData = useContext(SidebarContext)
  let history = useHistory();

  return (
    <>
        <Navbar data={sidebarData} />

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
          <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={() => history.push("/scenario/gather-information")}>Next Page</Button></Col>
        </Row>
    </>
  );
}
export default GatherInformation;