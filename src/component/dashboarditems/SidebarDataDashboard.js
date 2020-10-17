import React from 'react';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';

export const SidebarDataDashboard = {
  classes:{
    title: 'Classes',
    path: '/dashboard',
    icon: <AiIcons.AiFillHome />,
    clickable: true
  },
  results:{
    title: 'Results',
    path: '/dashboard/results',
    icon: <IoIcons.IoIosPaper />,
    clickable: true
  },
  support:{
    title: 'Support',
    path: '/dashboard/support',
    icon: <IoIcons.IoMdHelpCircle />,
    clickable: true
  }
}