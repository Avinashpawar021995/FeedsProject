import './App.css';
import { Route, BrowserRouter, Routes } from 'react-router-dom'; 
import Login from './Controller/Login';
import Base from './Controller/Base';
import Register from './Controller/Register';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AddPost from './Controller/AddPost';
import AllPost from './Controller/AllPost';
import UserRouter from './Controller/UserRouter';
import AdminRouter from './Controller/AdminRouter';
import MyPost from './Controller/MyPost';
  
function App() {
  return (
    <>
    <ToastContainer />
    <BrowserRouter>
      <Routes>
      <Route path='/' element={<Login/>}/>

    <Route path='/register' element={<Register/>}/>
  
     <Route path='/user' element={<UserRouter/>}> {/* private router  */}
    <Route path='post/:userId' element={<AddPost/>}/>
    <Route path='allpost' element={<AllPost />}/>
    <Route path='mypost' element={<MyPost/>}/>
   </Route>    
      <Route path='/admin' element={<AdminRouter/>}>
      <Route path='post/:userId' element={<AddPost />}/>
    <Route path='allpost' element={<AllPost/>}/>
         </Route>
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
