import React, { useEffect, useState } from 'react'
import { isLoggeIn } from '../Auth/Auths';
import { Navigate, Outlet } from 'react-router-dom';
const UserRouter = () => {
     const [role, setRole]= useState([]); 
      useEffect(()=>{
        setRole(isLoggeIn());
      })
      return isLoggeIn() ?<Outlet/> : <Navigate to={"/login"}/>
     return (
        <Outlet/>
  )
}

export default UserRouter
