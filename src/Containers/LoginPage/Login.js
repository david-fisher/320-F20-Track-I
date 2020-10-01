import React, { useEffect, useState } from 'react';
import { Row, Col, Form, Input, Button } from 'antd';
import { FormInput } from '../../component/Input'
import './index.css'
import { useHistory } from "react-router-dom";



//function component
const Login = () => {

    const history = useHistory()

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
                                <FormInput type="email" id="email" className="form-control login-input" onChange={e => setUsername(e.target.value)} placeholder="Enter email" />
                            </Form.Item>
                            <Form.Item
                                name="password"
                                rules={[{ required: true, message: 'Please input your password!' }]}
                            >
                                <FormInput type="password" onChange={e => setPassword(e.target.value)} placeholder="Enter password" />
                            </Form.Item>
                            <Form.Item >
                                <Button type="primary" htmlType="submit" onClick={() => history.push("/introduction")}>Submit</Button>
                            </Form.Item>
                        </Form>
                    </div>

                </Col>
            </Row>
        </div>
    );

}

export default Login