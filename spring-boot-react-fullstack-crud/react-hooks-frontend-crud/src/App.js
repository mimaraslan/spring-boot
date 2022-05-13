import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import AddEmployeeComponent from './components/AddEmployeeComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent/>
          <div className="container">
            <Routes>
              <Route exact path="/" element= {<ListEmployeeComponent/>}/>
              <Route exact path="/employees" element= {<ListEmployeeComponent/>}/>
              <Route exact path="/add-employee" element= {<AddEmployeeComponent/>}/>
              <Route exact path="/edit-employee/:id" element= {<AddEmployeeComponent/>}/>
            </Routes>
          </div>
          <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
