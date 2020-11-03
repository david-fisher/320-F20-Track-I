import  React, {useState, useContext} from 'react';
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


const ScenarioRouter = () => {

  const [conversationList,setConversationList] = useState([])
  const {state,update} = useContext(SidebarContext)

  //from backend
  const [stakeholders,setStakeholders] = useState([
    {
      name: "Stephen",
      conversation: "this is a conversation with stephen",
      bio: "1 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      disabled: false
    },
    {
      name: "Nisarg",
      conversation: "this is a conversation with nisarg",
      bio: "2 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      disabled: false
    },
    {
      name: "Jackie",
      conversation: "this is a conversation with jackie",
      bio: "3 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      disabled: false
    },
    {
      name: "Jeffrey",
      conversation: "this is a conversation with jefferey",
      bio: "4 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      disabled: false
    },
    {
      name:"Dan",
      conversation: "this is a conversation with dan",
      bio:"I am a loserrrr!!!",
      disabled: false

    },
    {
        name:"Vy",
        conversation: "this is a conversation with Vy",
        bio:"this is my bio",
        disabled: false

    },
    {
        name:"Vani",
        conversation: "this is a conversation with vani",
        bio:"testing testing",
        disabled: false

    },
    {
        name:"Sam",
        conversation: "this is a conversation with sam",
        bio:"Hello World!",
        disabled: false

    },
    {
        name:"Rachel",
        conversation: "this is a conversation with rachel",
        bio:"I am cool",
        disabled: false
    },
      
  ])

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
                <ConversationsPage conversationList={conversationList} setConversationList={setConversationList} stakeholders={stakeholders} setStakeholders={setStakeholders}/>
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
