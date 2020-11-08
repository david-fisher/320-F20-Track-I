import React, {useState, useContext,useEffect} from 'react';
import { Row, Col, Typography, Button, Input } from 'antd';
import { useHistory } from "react-router-dom";
import {SidebarContext} from '../../../component/SidebarContext';
import axios from "axios"

const InitialRelection = () => {
  
    const { Title, Paragraph, Text } = Typography;
    const { TextArea } = Input;

    const [answer1,setAnswer1] = useState("")
    const [answer2,setAnswer2] = useState("")
    const [irData,setIrData] = useState("")

    const {state,update} = useContext(SidebarContext)
    let history = useHistory()

    const handleClick = () => {

        history.push("/scenario/initial-action")
    
        let newSidebarState = state
        newSidebarState["projectTask"].routeTo = "initial-action"
        update({newSidebarState})
    
    }

    // useEffect(() => {    
    //     axios.get('http://localhost:8080/scenario/2/4/initialreflection',{
    //       headers: {
    //         "Access-Control-Allow-Origin": true
    //       }
    //     }).then(resp => {
    //         console.log("INCOMING!",resp)
    //         setIrData(resp.data.body)
    //     })
    //     .catch(err => {
    //       console.log("THIS IS THE ERROR",err)
    //     });
    //   }, [])
    
    //   useEffect(() => {
    //     console.log(irData)
    //   },[irData])



    return (
        <>
            <Row>
                <Col offset={5} span={18}>
                    <Title style={{color: "black"}}>Reflect on Initial Information</Title>
                    <Paragraph>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
                        when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
                        It has survived not only five centuries, but also the leap into electronic typesetting, 
                        remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset 
                        sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like 
                        Aldus PageMaker including versions of Lorem Ipsum.
                    </Paragraph>
                    <Text strong> 1. This is Question 1 to Reflect On.</Text><br/>
                    <TextArea rows={4} onChange={e => setAnswer1(e.target.value)}/>
                    <Text strong> 2. This is Question 2 to Reflect On.</Text><br/>
                    <TextArea rows={4} onChange={e => setAnswer2(e.target.value)}/>

                </Col>
            </Row>
            <Row>
                <Col offset={5}><Button type="primary" htmlType="submit" style={{marginTop: "10px"}} onClick={handleClick}>Next Page</Button></Col><Col offset={23}></Col>
            </Row>
        </>
    );
}
export default InitialRelection;