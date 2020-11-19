import React, { createContext, useReducer } from 'react'
import {SidebarDataScenario} from "./dashboarditems/SidebarDataScenario"
import './dashboarditems/Navbar.css';

export const SidebarContext = createContext()

const reducer = (state, pair) => ({ ...state, ...pair })

export function SidebarProvider(props) {
	const [state, update] = useReducer(reducer, SidebarDataScenario)

	return (
		<div className='parts'>
			<SidebarContext.Provider value={{ state, update }}>
				{props.children}
			</SidebarContext.Provider>
		</div>
	)
}