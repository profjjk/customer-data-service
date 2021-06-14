import React from 'react';
import PropTypes from 'prop-types';

function InputForm({ handleSubmit }) {
  return (
    <form className="mt-5" onSubmit={handleSubmit}>
      <div className="mb-3">
        <label className="form-label" htmlFor="firstName">First Name</label>
        <input className="form-control" type="text" name="firstName" id="firstName" />
        <label className="form-label" htmlFor="lastName">Last Name</label>
        <input className="form-control" type="text" name="lastName" id="lastName" />
      </div>
      <div>
        <label className="form-label" htmlFor="street">Street</label>
        <input className="form-control" type="text" name="street" id="street" />
      </div>
      <div className="mt-3">
        <label className="form-label" htmlFor="city">City</label>
        <input className="form-control" type="text" name="city" id="city" />
        <label className="form-label" htmlFor="state">State</label>
        <input className="form-control" type="text" name="state" id="state" />
        <label className="form-label" htmlFor="zipcode">Zip Code</label>
        <input className="form-control" type="text" name="zipcode" id="zipcode" />
      </div>
      <div className="mt-3">
        <label className="form-label" htmlFor="level">Level</label>
        <select name="level" id="level" className="form-select w-25" >
          <option>Gold</option>
          <option>Silver</option>
          <option>Bronze</option>
        </select>
        <button className="btn" type="submit">Submit</button>
      </div>
    </form>
  )
}

InputForm.propTypes = {
  handleSubmit: PropTypes.func.isRequired
};

export default InputForm;