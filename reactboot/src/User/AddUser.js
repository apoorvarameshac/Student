

import axios from 'axios';
import React, { useState } from 'react'
import {  Link, useNavigate } from 'react-router-dom';




export default function AddUser() {
  let Navigate=useNavigate()
  
  

const[user, setUser]=useState({
name:"",
adress:""


});
const{name,adress}=user
const oninputchange=(e)=>{
setUser({...user,[e.target.name]: e.target.value});
};

const onSubmit= async(e)=>{
  e.preventDefault();
  await axios.post("http://localhost:8080/save", user)
  Navigate("/")
};
 return (
    <div className='Container'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow' >
          <h2 className='text-centre m-4'>Register User</h2>

          <form onSubmit={(e)=> onSubmit(e)} >
          <div className='mb-3'>
          <label htmlFor='Name' className='Form-label'> Name</label>
          <input
          className='form-control'
          type='text'
          placeholder='Enter your name'
          name ='name'
          value={name}
          on onChange={(e)=>oninputchange(e)}
        
        />
        </div>
        <div className='mb-3'>
          <label htmlFor='Adress' className='Form-label'>Adress</label>
          <input
          className='form-control' 
          type='text'
          placeholder='enter your adress'
          name ='adress'
          value={adress}
          on onChange={(e)=>oninputchange(e)}
          
          
        />
        </div>
        
<button type='submit ' className='btn btn-outline-primary'>Submit</button>
<Link type='submit' className='btn btn-outline-danger  mx-2' to={"/"}> Cancel</Link>
</form>

           </div>
           

      </div>
    </div>
  )
}
