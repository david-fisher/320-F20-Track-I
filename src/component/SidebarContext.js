import React, { createContext, useReducer } from 'react'
import * as AiIcons from 'react-icons/ai';


export const SidebarContext = createContext()

const reducer = (state, pair) => ({ ...state, ...pair })

const initialState = {
    0: {
      title: 'Introduction',
      path: '/scenario',
      icon: <AiIcons.AiFillHome />,
      clickable: false
    },
    1: {
      title: 'Project Task',
      path: '/scenario/project-task',
      icon: <AiIcons.AiFillHome />,
      clickable: false
    },
    2: {
      title: 'Gather Info',
      path: '/scenario/gather-information',
      icon: <AiIcons.AiFillHome />,
      clickable: false
    },
    3: {
      title: 'Conversations',
      path: '/scenario',
      icon: <AiIcons.AiFillHome />,
      clickable: false
    },
    4: {
      title: 'Scenario Summary',
      path: '/scenario',
      icon: <AiIcons.AiFillHome />,
      clickable: false
    },
    5: {
      title: 'Feedback',
      path: '/scenario',
      icon: <AiIcons.AiFillHome />,
      clickable: false
    },
}

export function SidebarProvider(props) {
	const [state, update] = useReducer(reducer, initialState)

	return (
		<SidebarContext.Provider value={{ state, update }}>
			{props.children}
		</SidebarContext.Provider>
	)
}