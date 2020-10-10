import React from 'react';
import { Row, Col,Button } from 'antd';
import './index.css'
import { useHistory } from "react-router-dom";




//function component
const Login = () => {

    const history = useHistory()

    return (
        <div className="login">
            <Row align="middle">
                <Col xs={0} sm={0} md={8} lg={12} style={{ height: "100vh" }}>
                    <div className="image-container" />
                </Col>
                <Col sm={24} md={16} lg={12} style={{ height: "100vh" }}>
                    <div className="form">
                        <div><h1 className="header-text">LOGIN</h1></div>
                        <Button type="primary" 
                        style={{ background: "#A8431E", borderColor: "#881C1C" }} 
                        htmlType="submit" shape = "round" 
                        onClick={() => history.push("/dashboard")}>Lets Go!</Button>                    
                    </div>
                </Col>
            </Row>
        </div>
    );

}

export default Login