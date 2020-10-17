import React, {useState} from 'react';
import { Row, Col, Button, Typography } from 'antd';


const Stakeholder = (props) => {
  
    const { Title, Paragraph, Text } = Typography;
    const [showBio,setShowBio] = useState(false)
    const [buttonText,setButtonText] = useState("Expand")

    const handleClick = () => {
        setShowBio(!showBio)
        buttonText === "Expand" ? setButtonText("Collapse") : setButtonText("Expand")
    }

    return (
        <Row justify="center" >
            <Col span={8} offset={4}>
                <Button type="primary" onClick={handleClick} style={{marginRight:"20px"}}>{buttonText}</Button>
                <Text strong>{props.name}</Text><br/>
                {showBio ? props.bio : null}
            </Col>
        </Row>
    );
}
export default Stakeholder;