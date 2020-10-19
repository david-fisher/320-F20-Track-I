import  React, {useState, useContext} from 'react';
import { Switch, Route } from 'react-router-dom';
import ScenarioIntro from "./ScenarioIntro/ScenarioIntro"
import ProjectTask from "./ProjectTask/ProjectTask"
import InitialReflection from "./InitialReflection/InitialReflection"
import InitialAction from "./InitialAction/InitialAction"
import GatherInformation from './GatherInformation/GatherInformation';
import Conversations from './Conversations/Conversations'
import {SidebarContext} from "../../component/SidebarContext"
import Navbar from '../../component/dashboarditems/Navbar'


const ScenarioRouter = () => {

  const [conversationList,setConversationList] = useState([])
  const {state,update} = useContext(SidebarContext)

    return (
          <>
            <Navbar data={state} />
            <Switch>
              <Route exact path='/scenario' component={ScenarioIntro}/>
              <Route path='/scenario/project-task' component={ProjectTask}/>   
              <Route path='/scenario/initial-reflection' component={InitialReflection}/> 
              <Route path='/scenario/initial-action' component={InitialAction}/> 
              <Route path='/scenario/gather-information' component={GatherInformation}/>
              <Route path='/scenario/conversations'>
                <Conversations conversationList={conversationList} setConversationList={setConversationList}/>
              </Route>
            </Switch>
          </>
    );
  }
  
  export default ScenarioRouter

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
