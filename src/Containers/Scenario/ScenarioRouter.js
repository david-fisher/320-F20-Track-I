import  React, {useState, useContext, useEffect} from 'react';
import { Switch, Route } from 'react-router-dom';
import ScenarioIntro from "./ScenarioIntro/ScenarioIntro"
import ProjectTask from "./ProjectTask/ProjectTask"
import InitialReflection from "./InitialReflection/InitialReflection"
import InitialAction from "./InitialAction/InitialAction"
import GatherInformation from './GatherInformation/GatherInformation';
import ConversationsPage from './Conversations/ConversationsPage'
import {SidebarContext} from "../../component/SidebarContext"
import Navbar from '../../component/dashboarditems/Navbar'
import Conclusion from './Conclusion/Conclusion'
import HelpMenu from './Conversations/helpMenu';
import ConversationReflection from './ConversationReflection/ConversationReflection';
import FinalAction from './FinalAction/FinalAction';
import ScenarioSummary from './ScenarioSummary/ScenarioSummary';
import Feedback from './Feedback/Feedback';
import ConsequencesReflection from './ConsequencesReflection/ConsequencesReflection';
import axios from "axios"


const ScenarioRouter = () => {

  const [conversationList,setConversationList] = useState([])
  const {state,update} = useContext(SidebarContext)

  const [maxConvo,setMaxConvo] = useState(0)
  const [stakeholders,setStakeholders] = useState([])


  useEffect(() => {    
    axios.get('http://localhost:8080/student/1/scenario/2/3/stakeholderinfo',{
      headers: {
        "Access-Control-Allow-Origin": true
      }
    }).then(resp => {
        console.log("INCOMING!",resp)
        setMaxConvo(resp.data.body.max_conversations)
        setStakeholders(resp.data.body.StakeHolders)
    })
    .catch(err => {
      console.log("THIS IS THE ERROR",err)
    });

  }, [])



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
                <ConversationsPage conversationList={conversationList} setConversationList={setConversationList} stakeholders={stakeholders} setStakeholders={setStakeholders} maxConvo={maxConvo}/>
              </Route>
              <Route path='/scenario/conversation-reflection' component = {ConversationReflection}/>
              <Route path='/scenario/final-action' component = {FinalAction}/>
              <Route path='/scenario/summary' component = {ScenarioSummary}/>
              <Route path='/scenario/feedback' component = {Feedback}/>
              <Route path='/scenario/consequences-reflection' component = {ConsequencesReflection}/>
              <Route path='/scenario/conclusion' component = {Conclusion}/>
            </Switch>
            <HelpMenu/>
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
