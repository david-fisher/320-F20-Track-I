import React from 'react';
import './Classes.css';


function Support(props) {
  return (
    <>
    
      <div className='container'>
        <br/>
        <h1 align='center'>Ethics Simulation: Before Starting Questions.</h1>
        <br/><br/><br/>
        <h4>Will I be able to save my progress for each simulation?</h4>
        <div>No, you must reach the end of the simulation, otherwise if you leave the page your progress will reset.</div>
        <br/>
        <h4>I misclicked on a conversation and I want to go back, What do I do?</h4>
        <div>Can exit out of the simulation and restart aslong as you did not submit all your answers at the end.</div>
        <br/>
        <h4>Can I do a simulation multiple times?</h4>
        <div>You can only submit one simulation per class, the button to start for each class will be greyed out after completion.</div>
        <br/>
        <h4>Do my choices in the simulation affect my grade?</h4>
        <div>This simulation will be graded based on completion, answer honestly so your teacher can collect more accurate data.</div>
        <br/>
      </div>
    </>
  );
}

export default Support;