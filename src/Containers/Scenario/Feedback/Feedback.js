import React, {useContext,useEffect} from 'react';
import { Row, Col, Typography, Divider, Input, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import { Radar } from 'react-chartjs-2'


const Feedback = () => {

    const { Title, Paragraph } = Typography;
  
    const {state,update} = useContext(SidebarContext)

    let history = useHistory();

    const data = {
      labels: ['Ethic Thing 1', 'Ethic Thing 2', 'Ethic Thing 3', 'Ethic Thing 4', 'Ethic Thing 5', 'Ethic Thing 6'],
      datasets: [
        {
          label: '# of votes',
          data: [1,1,3,2,3,2],
          backgroundColor: 'rgba(255, 0, 0, 0.2)',
          borderColor: 'rgba(255, 0, 0, 1)',
          borderWidth: 1,
        },
      ],
    }

    const options = {
      scale: {
        ticks: { beginAtZero: true },
      },
    }


    const handleClick = () => {
        history.push("/scenario/consequences-reflection")
    }

    useEffect(() => {
      let newSidebarState = state
      newSidebarState["feedback"].clickable = true
      update({newSidebarState})
    }, [])
  
    return (
      <>
          <Row>
            <Col offset={5} span={18}>
                <Title style={{color: "black"}}>Feedback</Title>
                <Title style={{color: "black"}}>There will be a radar plot here soon...</Title>
                <Radar data={data} options={options} />
                <Paragraph>Words about the plot<br/><br/>
                </Paragraph>
                <Divider />
            </Col>
          </Row>
          <Row>
            <Col offset={5}><Button type="primary" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col>
          </Row>
      </>
    );
  }
  export default Feedback;