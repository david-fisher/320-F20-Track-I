import React from 'react';
import { Button } from 'antd';
import ConversationModal from "./ConversationModal"


const AlreadyHad = (props) => {

    return(
        <>
            <Button type="text" danger style={{marginRight:"20px"}} onClick={() => props.setShowModal(true)}>{props.name}</Button>
            <br/>
            <ConversationModal showModal={props.showModal} setShowModal={props.setShowModal} name={props.name} conversation={props.conversation}/>
        </>
    )
}

export default AlreadyHad