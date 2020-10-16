import React, { createContext, useReducer } from 'react'
import {SidebarDataScenario} from "./dashboarditems/SidebarDataScenario"

export const SidebarContext = createContext()

const reducer = (state, pair) => ({ ...state, ...pair })

export function SidebarProvider(props) {
	const [state, update] = useReducer(reducer, SidebarDataScenario)

	return (
		<SidebarContext.Provider value={{ state, update }}>
			{props.children}
		</SidebarContext.Provider>
	)
}