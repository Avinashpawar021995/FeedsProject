import React from 'react'
import Login from './Login'
import AddPost from './AddPost'

const Base = ({children}) => {
  return (
    <div className="container">
        <div className="row">
            <div className="card">
                <div className="card-body">
                    <div className="col-md-12">
                         <h1 className='fs-2 fw-bold'>Feed application</h1>
                    </div>
                    <div className="col-md-12">
                        {children}
                    </div>
                    <div className="col-md-12">

                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Base
