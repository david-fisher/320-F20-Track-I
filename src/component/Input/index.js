import React from 'react';
import { Input } from 'antd';
import './index.css'

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