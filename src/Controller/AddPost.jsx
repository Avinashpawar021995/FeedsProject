import React, { useEffect, useState } from 'react'
import { toast } from 'react-toastify';
import Base from './Base';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
const AddPost = () => {
  const [data, setPostData]=useState('')
  const { userId }=useParams();
   const handlerEvent=(event, property)=>{
    setPostData({...data, [property]:event.target.value})
      }
    const isSubmitpage=(e)=>{
       e.preventDefault();
       getAddPost();
             }        

         const getAddPost=()=>{
          axios.post(`http://localhost:8892/post/${userId}`, data).then((response)=>{      
              toast.success("post is add success fully...");
            }).catch((error)=>{
              console.log();
            toast.error("add post");
         })
         }

    return (
   <Base>
        <div className="card">
            <div className="card-body">
                <form onSubmit={isSubmitpage}> 
                 <div className="col-md-12">
                    <h1 className='fs-2 fw-bold'>add post</h1>
                   </div>           
                    <div className="col-md-12">
                    <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">postfield</span>
                  <input type="textarea" 
                    id='postfield'                     
                  className="form-control" 
                      placeholder="postfield"
                    aria-label="postfield" 
                    aria-describedby="basic-addon1"
                    onChange={(e)=>{handlerEvent(e, 'postfield')}}
                    />
                 </div>
                    </div>
                    <div className="col-md-12 p-md-3">
                        <button type='submit' className='btn btn-success p-md-2 me-sm-3'>create post</button> 
                    </div>
                    <div className="col-md-12">
                    <Link to="/myPost" className='btn btn-primary mx-md-3' role="button">view my post</Link>
                    </div>
                    <div className="col-md-12">
                    <Link to="/user/allpost" className='btn btn-primary mx-md-3' role="button">view all post</Link>
                    </div>
                </form>
            </div>
        </div>
   </Base>    
)
}
export default AddPost
