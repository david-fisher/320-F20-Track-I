import React from 'react';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';

export const SidebarDataScenario = {
  introduction: {
    title: 'Introduction',
    path: '/scenario',
    icon: <AiIcons.AiFillHome />,
    clickable: false
  },
  projectTask: {
    title: 'Project Task',
    path: '/scenario/project-task',
    icon: <AiIcons.AiFillHome />,
    clickable: false,
    routeTo: "initial-reflection"
  },
  gatherInformation: {
    title: 'Gather Info',
    path: '/scenario/gather-information',
    icon: <AiIcons.AiFillHome />,
    clickable: false
  },
  conversations: {
    title: 'Conversations',
    path: '/scenario',
    icon: <AiIcons.AiFillHome />,
    clickable: false
  },
  summary: {
    title: 'Scenario Summary',
    path: '/scenario',
    icon: <AiIcons.AiFillHome />,
    clickable: false
  },
  feedback: {
    title: 'Feedback',
    path: '/scenario',
    icon: <AiIcons.AiFillHome />,
    clickable: false
  },
}