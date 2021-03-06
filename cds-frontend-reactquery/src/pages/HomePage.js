import { useMutation, useQuery, useQueryClient } from 'react-query';
import { InputForm, CustomerTable } from 'components';
import React from 'react';
import API from '../API';

const fetchCustomers = async () => await API.getAll();

const HomePage = () => {
  // Fetch all records from database and hold in state.
  const { status, data, error } = useQuery('customers', fetchCustomers);

  const queryClient = useQueryClient();

  const addCustomer = useMutation(customer => API.create(customer));
  const deleteCustomer = useMutation(id => API.delete(id));

  const handleSubmit = event => {
    event.preventDefault();
    addCustomer.mutate(Object.fromEntries(new FormData(event.target)), {
      onSuccess: () => {
        queryClient.invalidateQueries('customers');
      }
    });
  };

  const handleDelete = event => {
    event.preventDefault();
    deleteCustomer.mutate(event.target.dataset.id, {
      onSuccess: () => {
        queryClient.invalidateQueries('customers');
      }
    })
  }

  switch (status) {
    case 'loading':
      return <h1 className="text-center mt-5">Loading</h1>;
    case 'error':
      return <h4>{error.message}</h4>;
    default:
      return (
        <div className="container">
          <h1 className="text-center mt-5">Customer Database</h1>
          <InputForm handleSubmit={handleSubmit} />
          <CustomerTable customers={data} handleDelete={handleDelete} />
        </div>
      )
  }
}

export default HomePage;