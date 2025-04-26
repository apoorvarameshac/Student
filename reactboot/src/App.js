
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/navbar';
import Home from './pages/home';
import { BrowserRouter as Router,Routes,Route, BrowserRouter} from 'react-router-dom';
import AddUser from './User/AddUser';

function App() {
  return (
    <div className="App">
      <Router>
      <Navbar/>
      <Routes>
        <Route exact path='/' element={<Home/>}/>
        <Route exact path="/AddUser" element={<AddUser/>}/>
      </Routes>
      </Router>
    

         
      
    </div>
  );
  
}

export default App;
