import React from 'react';
import { Row, Col, Typography, Image } from 'antd';
import { ArrowRightOutlined } from '@ant-design/icons';

//function component
const Disclosure = () => {

    const { Title, Paragraph } = Typography;

    return (
        <div>
            <Row justify="center" style={{ marginBottom: "30px" }}>
                <Col>
                    <div style={{ backgroundColor: "#881C1C", height: "200px", width: "100vw" }}>
                        <Title level={2} style={{ textAlign: "center", lineHeight: "200px", color: "white" }}>Ethics Simulation Introduction</Title>
                    </div>
                    <Image width="100%" src="/img/Vector.svg" />
                </Col>
            </Row>
            <Row justify="start">
                <Col span={20} offset={1}>
                    <Paragraph style={{ fontSize: "30px", lineHeight: "38px" }}>
                        You will be taking part of a simulation to test your ethical awareness.
                        You answers will be recorded and there is no going back once a decision is made so becareful.
                    </Paragraph>
                </Col>
            </Row>
            <Row justify="start">
                <Col span={20} offset={1}>
                    <Paragraph style={{ fontSize: "30px", lineHeight: "38px" }}>
                        Please answer these questions truthfully based on what you would do given the situations.
                        To proceed, please press on the arrow on the bottom left, there is no time limit so take your time.
                    </Paragraph>
                </Col>
            </Row>
            <Row justify="start">
                <Col span={2} offset={22}>
                    <ArrowRightOutlined style={{ fontSize: "50px" }} onClick={() => history.push("/dashboard")} />
                </Col>
            </Row>
        </div>
    );

}

export default Disclosure