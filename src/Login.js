import React, { useEffect, useState } from 'react';
import students from "./students.jpeg"

//function component
const Login = () => {

    //state hooks
    const [username,setUsername] = useState("")
    const [password,setPassword] = useState("")

    //temporary, inspect the webpage and you can see state changes as you type
    useEffect(() => {
        console.log("Username: ",username," Password: ",password)
    },[username,password])


    return (
        <div className="container-fluid" style={{backgroundColor: "#881C1C"}}>
            <div className="row">
                <div className="col">
                    <img src={students} alt="students working" className="img-fluid"/>
                </div>
                <div className="col align-self-center text-center">
                    <p className="lead text-white">LOGIN</p>
                    <form>
                        <div className="form-group">
                            <input type="email" id="email" className="form-control" onChange={e => setUsername(e.target.value)} placeholder="Enter email"/>
                        </div>
                        <div className="form-group">
                            <input type="password" id="password" className="form-control" onChange={e => setPassword(e.target.value)} placeholder="Enter password"/>
                        </div>
                        <button type="button" className="btn btn-danger">Let's Go!</button>
                    </form>
                </div>
            </div>
        </div>
    );

}

export default Login