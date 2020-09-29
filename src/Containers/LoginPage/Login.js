import React, { useEffect, useState } from 'react';
import { Row, Col, Form, Input, Button } from 'antd';
import './index.css'


//function component
const Login = () => {

    //state hooks
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    //temporary, inspect the webpage and you can see state changes as you type
    useEffect(() => {
        console.log("Username: ", username, " Password: ", password)
    }, [username, password])


    return (
        <div className="login">
            <Row align="middle">
                <Col xs={0} sm={0} md={8} lg={12} style={{ height: "100vh" }}>
                    <div className="image-container" />
                </Col>
                <Col sm={24} md={16} lg={12} style={{ height: "100vh" }}>
                    <div className="form">
                        <div><h1 className="header-text">LOGIN</h1></div>
                        <Form align="middle">
                            <Form.Item
                                name="username"
                                rules={[{ required: true, message: 'Please input your username!' }]}
                            >
                                <Input type="email" id="email" className="form-control" onChange={e => setUsername(e.target.value)} placeholder="Enter email" />
                            </Form.Item>
                            <Form.Item
                                name="password"
                                rules={[{ required: true, message: 'Please input your password!' }]}
                            >
                                <Input.Password onChange={e => setPassword(e.target.value)} placeholder="Enter password" />
                            </Form.Item>
                            <Form.Item >
                                <Button type="primary" htmlType="submit">
                                    Submit
                        </Button>
                            </Form.Item>
                        </Form>
                    </div>

                </Col>
            </Row>
        </div>
    );

}

export default Login