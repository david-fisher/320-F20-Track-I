import React, {useState} from 'react';
import { Button } from 'antd';
import ConversationModal from "./ConversationModal"


const ConversationsAlreadyHad = (props) => {

    const [showModal,setShowModal] = useState(false)

    return(
        <>
            <Button type="text" danger style={{marginRight:"20px"}} onClick={() => setShowModal(true)}>{props.name}</Button>
            <br/>
            <ConversationModal showModal={showModal} setShowModal={setShowModal} name={props.name} conversation={props.conversation}/>
        </>
    )
}

export default ConversationsAlreadyHad