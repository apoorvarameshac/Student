import React, { useEffect, useState } from 'react'
import axios from 'axios'
export default function Home() {
    const [user,setUser]= useState([])
    useEffect(()=>{
    loadUser();


    },[]);

    const loadUser=async()=>{
        const result = await axios.get("http://localhost:8080/get")
      setUser(result.data);
    }
  return (
    <div className='container' >
        <div className='py-4'> 
        <table className= "table border shadow" >
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">name</th>
     
      <th scope="col">adress</th>
      <th scope='col'> Action </th>

    </tr>
  </thead>
  <tbody>

    {
        user.map((user,index)=>(
            
<tr>
      <th scope="row" key={index}>{index+1}</th>
      <td>{user.name}</td>
      <td>{user.adress}</td>
      <td>

       <button className='btn btn-primary mx-2'> View</button>
       <button className='btn btn-outline-primary mx-2'>Edit </button>
       <button className='btn btn-danger mx-2'>Delete </button>
      </td>
      
      
      
      
    </tr>
        ))
        }
    
  </tbody>
</table>
        
        </div>

    </div>
  )
}
