import http from 'k6/http';

export const options = {
  vus: 10,           // Number of virtual users
  iterations: 100,   // Total iterations to be shared across VUs
};

export default function () {
  http.get('http://localhost:8081/client/products');

  http.get('http://localhost:8081/client/products/1');
  http.get('http://localhost:8081/client/products/2');
  http.get('http://localhost:8081/client/products/3');
  sleep(1); 
}
