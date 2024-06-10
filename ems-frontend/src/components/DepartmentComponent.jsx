import React, { useEffect, useState } from 'react';
import { createDepartment, getDepartmentById, updateDepartment } from '../services/DepartmentService';
import { useNavigate, useParams } from 'react-router-dom';

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState('');
  const [departmentDescription, setDepartmentDescription] = useState('');

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getDepartmentById(id).then((response) => {
        setDepartmentName(response.data.departmentName);
        setDepartmentDescription(response.data.departmentDescription);
      }).catch(error => {
        console.error(error);
      });
    }
  }, [id]);

  const saveOrUpdateDepartment = (e) => {
    e.preventDefault();

    const department = { departmentName, departmentDescription };

    if (id) {
      updateDepartment(id, department).then((response) => {
        console.log(response.data);
        navigate('/departments');
      }).catch(error => {
        console.error(error);
      });
    } else {
      createDepartment(department).then((response) => {
        console.log(response.data);
        navigate('/departments');
      }).catch(error => {
        console.error(error);
      });
    }
  };

  const pageTitle = () => {
    return id ? <h2 className='text-center'>Update Department</h2> : <h2 className='text-center'>Add Department</h2>;
  };

  return (
    <div className='container'><br /><br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3'>
          {pageTitle()}
          <div className='card-body'>
            <form onSubmit={saveOrUpdateDepartment}>
              <div className='form-group mb-2'>
                <label className='form-label'>Department Name:</label>
                <input
                  type='text'
                  name='departmentName'
                  placeholder='Enter Department Name'
                  value={departmentName}
                  onChange={(e) => setDepartmentName(e.target.value)}
                  className='form-control'
                  required
                />
              </div>
              <div className='form-group mb-2'>
                <label className='form-label'>Department Description:</label>
                <input
                  type='text'
                  name='departmentDescription'
                  placeholder='Enter Department Description'
                  value={departmentDescription}
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                  className='form-control'
                  required
                />
              </div>
              <button type='submit' className='btn btn-primary'>Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DepartmentComponent;
