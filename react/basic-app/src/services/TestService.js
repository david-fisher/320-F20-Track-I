import axios from 'axios';

const HOMPAGE_REST_API_URL = 'http://localhost:8080/test';


class HomepageService{

  getData(){
    const response = axios.get(HOMPAGE_REST_API_URL);
    console.log("test");
    console.log(response);
    return response;
  }
}

export default new HomepageService();
