import React from 'react';
import { Typography, Modal } from 'antd';

const ConversationModal = (props) => {

    const { Text } = Typography;

    return (
        <Modal
            title={props.name}
            visible={props.showModal}
            onOk={() => props.setShowModal(false)}
            okText="Close"
            cancelButtonProps={{ style: { display: 'none' } }}
            closable={false}
        >
            <Text>{props.conversation}</Text>
        </Modal>
    );
}
export default ConversationModal;