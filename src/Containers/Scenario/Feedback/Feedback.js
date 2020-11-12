import React, {useContext,useEffect,useState} from 'react';
import { Row, Col, Typography, Divider, Input, Button } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import { Radar } from 'react-chartjs-2'
import axios from "axios"


const Feedback = () => {

    const { Title, Paragraph } = Typography;
  
    const {state,update} = useContext(SidebarContext)

    let history = useHistory();

    const [finalscore,setFinalscore] = useState("")

    const data = {
      labels: Object.keys(finalscore),
      datasets: [
        {
          label: '# of votes',
          data: Object.values(finalscore),
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

      axios.get('http://localhost:8080/student/2/scenario/1/2/finalscore',{
        headers: {
          "Access-Control-Allow-Origin": true
        }
      }).then(resp => {
          console.log("INCOMING!",resp)
          setFinalscore(resp.data.body)
      })
      .catch(err => {
        console.log("THIS IS THE ERROR",err)
      });

    }, [])
  

  
    return (
      <>
          <Row>
            <Col offset={5} span={18}>
                <Title style={{color: "black"}}>Feedback</Title>
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