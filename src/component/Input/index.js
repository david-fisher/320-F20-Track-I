import React from 'react';
import { Input } from 'antd';
import './index.css'

const style = {
   // backgroundColor: 'black',
   // border: 'none',
   // borderBottom: '3px solid white',
   // width: '500px',
   // color: 'white'
}
export const FormInput = (props) => {
   if (props.type === 'email') {
      return (
         <Input type={props.type} id={props.id} className={props.className + ' email'} onChange={props.onChange} placeholder={props.placeholder} style={style} />
      );
   }

   if (props.type === 'password') {
      return (
         <Input.Password className="password" onChange={props.onChange} placeholder={props.placeholder} style={style} />
      );
   }
}