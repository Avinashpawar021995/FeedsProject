import React, { useState } from 'react'
import {Link, useNavigate} from 'react-router-dom'
import { toast } from 'react-toastify';
import { userlogin } from '../ApiConfign/Confign';
const Login = () => {
  const [use, setUser]=useState({
    email:'',
    password:''
  });
   const [login ,setLogin]=useState([]);
  const navigate= useNavigate();     
 const handlerEvent=(event, property)=>{
     setUser({...use, [property]:event.target.value})
  }
const isSubmitpage=(e)=>{
e.preventDefault();
  setLoginUser();
 } 
    
const setLoginUser=()=>{
    userlogin(use).then((response)=>{  

          setLogin(response);
        toast.success("user login success fully...");
          //alert(response.id);    
        navigate("/user/post"+response.id)
        }).catch((error)=>{
           console.log(error);
            toast.error("please check user name  and password");
          })}

return (
 <>
 <div className="container">
    <div className="row text-center">
        <div className="card">
            <div className="card-body">
                <form action="" onSubmit={isSubmitpage}>
                    <div className="col-md-12">
                        <h1 className='fs-1 fw-bold'>Login Page</h1>
                    </div>
                    <div className="col-md-12">
                    <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">email</span>
                  <input type="text"  
                        name="email" 
                      id='email'
                      className="form-control"
                      placeholder="email"
                    aria-label="email" 
                    aria-describedby="basic-addon1"
                    onChange={(e)=>{handlerEvent(e, 'email')}}
                    />
                 </div>
                    </div>
                    <div className="col-md-12">
                    <div className="input-group mb-3">
                     <span className="input-group-text" id="basic-addon2">password</span>
                  <input type="text" 
                  name='password' 
                  id='password'
                    className="form-control"
                     placeholder="password" 
                     aria-label="password"
                      aria-describedby="basic-addon2"
                      onChange={(e)=>{handlerEvent(e, 'password')}}
                      />
                 </div>
                    </div>
                    <div className="col-md-12 p-md-3">
                        <button type='submit' className='btn btn-success p-md-2 me-sm-3'>Login</button>
                        <Link to="/register" className='btn btn-primary mx-md-3' role="button">register</Link>
                    </div>
                </form>
            </div>
        </div>
    </div>
 </div> 
 </>   
)
}
export default Login
