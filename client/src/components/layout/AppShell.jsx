import React from 'react';
import LeftSidebar from './LeftSidebar';
import TopBar from './TopBar';
import RightSidebar from './RightSidebar';
import { useMediaQuery } from '../../hooks/useMediaQuery';

const AppShell = ({ children }) => {
  const isLargeScreen = useMediaQuery('(min-width: 1024px)');
  
  return (
    <div className="flex h-screen bg-gradient-to-br from-slate-50 to-blue-50 dark:from-slate-900 dark:to-blue-900">
      <LeftSidebar />
      <div className="flex-1 flex flex-col overflow-hidden">
        <TopBar />
        <main className="flex-1 overflow-y-auto p-4 md:p-6">
          <div className="max-w-7xl mx-auto">
            {children}
          </div>
        </main>
      </div>
      {isLargeScreen && <RightSidebar />}
    </div>
  );
};

export default AppShell;
