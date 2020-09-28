import React from 'react';
import HomepageService from '../services/TestService.js';

class HomepageComponent extends React.Component{

  constructor(props){
    super(props);
    this.state={
      data:[]
    }
  }

  componentDidMount(){
    console.log('I was triggered during componentDidMount');
    HomepageService.getData().then((response) => {
            this.setState({ data: response.data})
        });
    console.log(this.state.data)
  }

  render(){
    return(
      <div>
        <h1 className = "text-center">Test</h1>
      </div>
    )
  }
}

export default HomepageComponent
