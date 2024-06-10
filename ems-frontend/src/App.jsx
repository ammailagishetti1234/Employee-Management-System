
import './App.css'
import DepartmentComponent from './components/DepartmentComponent'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListDepartment from './components/ListDepartment'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {

  return (
    <>
    <BrowserRouter>
      <HeaderComponent></HeaderComponent>
      <Routes>
      {/* // http://localhost:3000 */}
        <Route path='/' element = { <ListEmployeeComponent></ListEmployeeComponent>}></Route>
      {/* // http://localhost:3000/employees */}
         <Route path='/employees' element = { <ListEmployeeComponent></ListEmployeeComponent>}></Route>

         {/* // http://localhost:3000/add-employee */}
         <Route path='/add-employee' element = { <EmployeeComponent></EmployeeComponent>}></Route>

          {/* // http://localhost:3000/edit-employee */}
          <Route path='/edit-employee/:id' element = { <EmployeeComponent></EmployeeComponent>}></Route>

         {/* // http://localhost:3000/departments */}
          <Route path='/departments' element = { <ListDepartment></ListDepartment>}></Route>

         {/* // http://localhost:3000/add-departments */}
          <Route path='/add-department' element = { <DepartmentComponent></DepartmentComponent> }></Route>

          {/* // http://localhost:3000/edit-departments */}
          <Route path='/edit-department/:id' element = { <DepartmentComponent></DepartmentComponent>}></Route>
      </Routes>
      
      <FooterComponent></FooterComponent>
    </BrowserRouter>
    </>
  )
}

export default App
