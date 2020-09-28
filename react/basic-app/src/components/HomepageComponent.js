import React from 'react';
import HomepageService from '../services/TestService.js';

class HomepageComponent extends React.Component{

  constructor(props){
    super(props);
    this.state={
      text:[]
    }
  }

  componentDidMount(){
    console.log('I was triggered during componentDidMount');
    HomepageService.getData().then((response) => {
            this.setState({ text: response.data})
        });
    console.log(this.state.text)
  }

  render(){
    return(
      <div>
        <h1 className = "text-center">{this.state.text.success}</h1>
      </div>
    )
  }
}

export default HomepageComponent
