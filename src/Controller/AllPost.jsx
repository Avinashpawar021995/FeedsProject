import React, { useEffect, useState } from 'react'
import Base from './Base'
import { toast } from 'react-toastify';
import axios from 'axios';
import { Link } from 'react-router-dom';
const AllPost = () => {
  
    const [post , setAllPost]=useState([]);
      useEffect(()=>{
    axios.get(`http://localhost:8892/post`).then((response)=>{
        setAllPost(response.data);
        console.log(response.data);
    }).catch((error)=>{
        toast.error(error)
    })
  },[])
    return (
    <Base>
     { 
     post.map((post1, index)=>{
        return(<>
    <div className="card">
        <div className="card-body" key={index}>
           <p>{post1.postfield}</p>
           <p>{ post1.date}</p>  
           <p>{post1.user?.name}</p>
         {post1.user?.role==="user" ? <p><Link to={post.user?.id} className='fs-6 btn btn-primary' role='button'>update</Link></p>:''}
         {post1.user?.role === "admin" ? <p><Link to={post.user?.id} className='fs-6 btn btn-success' role='button'>approve</Link></p>:''}
           <p><Link to={post.user?.id} className='fs-6 btn btn-danger' role='button'>delete</Link></p>
           
        </div>
     </div>
    {/*      <tr >
            <td>{post1.postfield}</td>
            <td>{post1.date}</td>
            <td>{post1.user.name}</td>

          </tr> */}
        </>      );
     })

      }
    </Base>
  )
}

export default AllPost
