import React from 'react';
import PropTypes from 'prop-types';

function CustomerTable({ customers }) {
  return (
    <table className="table mt-5">
      <thead>
        <tr>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Street</th>
          <th scope="col">City</th>
          <th scope="col">State</th>
          <th scope="col">Zip Code</th>
          <th scope="col">Level</th>
        </tr>
      </thead>
      <tbody>
        {customers.map(({ id, firstName, lastName, street, city, state, zipcode, level }) => (
          <tr key={id}>
            <td>{firstName}</td>
            <td>{lastName}</td>
            <td>{street}</td>
            <td>{city}</td>
            <td>{state}</td>
            <td>{zipcode}</td>
            <td>{level}</td>
          </tr>
        ))}
      </tbody>
    </table>
  )
}

CustomerTable.propTypes = {
  customers: PropTypes.arrayOf(
    PropTypes.exact({
      id: PropTypes.number.isRequired,
      firstName: PropTypes.string.isRequired,
      lastName: PropTypes.string.isRequired,
      street: PropTypes.string.isRequired,
      city: PropTypes.string.isRequired,
      state: PropTypes.string.isRequired,
      zipcode: PropTypes.string.isRequired,
      level: PropTypes.string.isRequired
    })
  ),
};

export default CustomerTable;