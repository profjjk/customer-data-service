import ky from 'ky';

const baseUrl = "http://localhost:8080/customers/";

const API = {
  getAll() {
    return ky.get(baseUrl).json();
  },
  getById(id) {
    return ky.get(baseUrl + id).json();
  },
  getByLevel(level) {
    return ky.get(baseUrl + "level/" + level)
  },
  getByState(state) {
    return ky.get(baseUrl + "state/" + state)
  },
  create(customer) {
    return ky.post(baseUrl, { json: customer }).json();
  },
  delete(id) {
    return ky.delete(baseUrl + id);
  }
}

export default API;