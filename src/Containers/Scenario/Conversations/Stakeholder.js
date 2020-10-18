import React, {useState} from 'react';
import { Row, Col, Button, Typography } from 'antd';
import {BsChevronDown} from 'react-icons/bs';
import {BsChevronUp} from 'react-icons/bs';
import ConversationModal from "./ConversationModal"



const Stakeholder = (props) => {
  
    const { Text } = Typography;
    const [showBio,setShowBio] = useState(false)
    const [showModal,setShowModal] = useState(false)
    const [expanded,setExpanded] = useState(false)
    const [disabled,setDisabled] = useState(false)

    const handleExpand = () => {
        setShowBio(!showBio)
        setExpanded(!expanded)
    }

    const handleConversation = () => {
        if(!props.conversationList.includes(props.name))
            props.setConversationList(props.conversationList.concat({name: props.name, conversation: props.conversation}))
        setShowModal(true)
        setDisabled(true)
    }

    return (
        <>
            <Row style={{marginBottom:"10px"}}>
                <Col span={3} offset={6}>
                    {expanded ? <BsChevronUp onClick={handleExpand} style={{marginRight:"1vw"}} />: <BsChevronDown onClick={handleExpand} style={{marginRight:"1vw"}} />}
                    <Text strong>{props.name}</Text>
                </Col>
                <Col>
                    {disabled ? <Button disabled style={{marginRight:"20px"}} onClick={handleConversation}>Choose</Button> : <Button danger style={{marginRight:"20px"}} onClick={handleConversation}>Choose</Button>}
                </Col>
            </Row>
            <Row>
                <Col span={16} offset={6}>
                {showBio ? props.bio : null}
                </Col>
            </Row>
            <ConversationModal showModal={showModal} setShowModal={setShowModal} name={props.name} conversation={props.conversation}/>
        </>
    );
}
export default Stakeholder;