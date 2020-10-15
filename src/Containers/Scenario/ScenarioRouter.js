import  React, {useEffect, useState } from 'react';
import Navbar from '../../component/dashboarditems/Navbar';
import {SidebarDataScenario} from "../../component/dashboarditems/SidebarDataScenario"
import { BrowserRouter as Switch, Route, withRouter } from 'react-router-dom';
import ScenarioIntro from "./ScenarioIntro/ScenarioIntro"
import ProjectTask from "./ProjectTask/ProjectTask"
import InitialReflection from "./InitialReflection/InitialReflection"
import InitialAction from "./InitialAction/InitialAction"
import GatherInformation from './GatherInformation/GatherInformation';

const ScenarioRouter = () => {

    const [sideBarData,setSideBarData] = useState([])

    return (
      <>
        <Switch>
          <Route exact path='/scenario'> <ScenarioIntro data={sideBarData} setData={setSideBarData} /> </Route> 
          <Route path='/scenario/project-task'> <ProjectTask data={sideBarData} setData={setSideBarData} /> </Route>   
          <Route path='/scenario/initial-reflection'> <InitialReflection data={sideBarData}/></Route>
          <Route path='/scenario/initial-action'> <InitialAction data={sideBarData}/></Route>
          <Route path='/scenario/gather-information'> <GatherInformation data={sideBarData} setData={setSideBarData}/></Route>

        </Switch>
      </>
    );
  }
  
  export default withRouter(ScenarioRouter)

  //****intro - no inputs, can go back
//****project task - no inputs, can go back

//reflection questions - does not appear in navbar, cant go back
//choose initial action - does not appear in navbar, cant go back

//****start to gather information - no inputs, can go back

//choose a conversation, each person as info, pick one, next

//**** each conversation had is added to navbar and return to conversations page (conversation grays out if chosen)

//reflection questions on conversations - does not appear in navbar, cant go back
//choose final action

//**** summary of the scenario - what the student was suppose to gain, just text - added to navbar

//**** feedback - A GRAPH - added to navbar

//reflection questions on consequences

//conclusion - questions
