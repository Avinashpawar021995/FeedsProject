import React, { useState } from 'react'
import Base from './Base'
import { Link } from 'react-router-dom'
import { userRegister } from '../ApiConfign/Confign'
import {toast} from 'react-toastify'
const Register = () => {
  const [use, setUser]=useState({ 
    name:'',
    password:'',
    email:'',
    phone_no:'',
    role:'' })
      
  // handle change
     const handleChange =(event, property)=>{
      //dynamic setting the value
     setUser({...use,[property]:event.target.value})
     } 
    const isRegister=(e)=>{
    e.preventDefault();
   userRegister(use).then((data)=>{
      console.log(data);
    toast.success("user register successfully")
    setUser(
        {
          name:'',
          password:'',
          email:'',
          phone_no:'',
          role:''
      }
      )
     }).catch((error)=>{
         console.log(error);
         toast.error("please check informatiom..")
         setUser(
          {
            name:'',
            password:'',
            email:'',
            phone_no:'',
            role:''
        })
        })
     }

    return (
    <Base>
    <div className="card">
        <div className="card-body">
            <form onSubmit={isRegister}>
            <div className="row">
            <div class="input-group mb-3">
                     <span class="input-group-text" id="input1">name</span>
                     <input
                       type="text"
                       id='name'
                       class="form-control"
                       placeholder="name"
                       aria-label="name"
                       onChange={(e)=>handleChange(e, 'name')}
                         />
                   </div>
                   <div class="input-group mb-3">
                     <span class="input-group-text" id="input1">password</span>
                     <input
                       type="text"
                       id='password'
                       class="form-control"
                       placeholder="password"
                       aria-label="password"
                         onChange={(e)=>handleChange(e, 'password')}
                         />
                   </div>
                   <div class="input-group mb-3">
                     <span class="input-group-text" id="input1">email</span>
                     <input
                       type="text"
                       id='email'
                       class="form-control"
                       placeholder="email"
                       aria-label="email"
                             onChange={(e)=>handleChange(e, 'email')}
                         />
                   </div>
 
                    <div class="input-group mb-3">
                     <span class="input-group-text" id="input1">phone_no</span>
                     <input
                       type="text"
                      id='phone_no'
                       class="form-control"
                       placeholder="phone_no"
                       aria-label="phone_no"
                       onChange={(e)=>handleChange(e, 'phone_no')}
                         />
                         </div>
                    <div class="input-group mb-3">
                      <span class="input-group-text" id="input1">role</span>
                  <select name='role' id="role" onChange={(e)=>handleChange(e, 'role')}
                         >
                          <option >select role</option>
                       <option  value="admin">admin</option>
                       <option  value="user">user</option>
                         </select>
                                          </div>
                   <div>
                     <button type='submit' className='me-md-3'>register</button>
            <Link to={"/"} className='fs-4 mx-md-4 p-2' role='button'>Login</Link>
                   </div>
            
        </div>
   </form>
    </div>
</div>

    </Base>
  )
}

export default Register
