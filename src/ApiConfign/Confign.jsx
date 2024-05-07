import axios from 'axios'
const BASE_URL="http://localhost:8892";


export const userlogin=(user)=>{
    return axios.post(`http://localhost:8892/app/login`, user).then(response=>response.data);
}

export const userRegister=(user)=>{
    return axios.post(`http://localhost:8892/app/reg`, user).then(response=>response.data);
}
export const postCreate=(data, id)=>{
    return axios.post(`http://localhost:8892/post/${id}`, data).then(response=>response.data);
}

export const getAllPost=()=>{
    return axios.get(`http://localhost:8892/post`).then(response=>response.data);
}

