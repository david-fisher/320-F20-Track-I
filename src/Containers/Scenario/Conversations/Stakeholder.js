import React, {useState} from 'react';
import { Row, Col, Button, Typography, Radio } from 'antd';


const Stakeholder = (props) => {
  
    const { Title, Paragraph, Text } = Typography;
    const [showBio,setShowBio] = useState(false)
    const [buttonText,setButtonText] = useState("Expand")

    const handleExpand = () => {
        setShowBio(!showBio)
        buttonText === "Expand" ? setButtonText("Collapse") : setButtonText("Expand")
    }

    const handleConversation = () => {
        if(!props.conversationList.includes(props.name))
            props.setConversationList(props.conversationList.concat(props.name))
    }

    return (
        <>
            <Row style={{marginBottom:"20px"}}>
                <Col span={4} offset={6}>
                    <Button type="primary" onClick={handleExpand} style={{marginRight:"1vw"}}>{buttonText}</Button>
                    <Text strong>{props.name}</Text>
                </Col>
                <Col><Button type="primary" style={{marginRight:"20px"}} onClick={handleConversation}>Choose</Button></Col>
            </Row>
            <Row>
                <Col span={16} offset={6}>
                {showBio ? props.bio : null}
                </Col>
            </Row>
        </>
    );
}
export default Stakeholder;