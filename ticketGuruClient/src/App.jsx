import React, { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom';
import './App.css'
import TicketList from './ticketList';
import EventList from './EventList';
import TicketUsed from './TicketUsed';
import Login from './Login';

export default function App() {
  const [authenticated, setAuthenticated] = useState(false);

  useEffect(() => {
    const storedAuthState = localStorage.getItem('authenticated');
    if (storedAuthState) {
      setAuthenticated(JSON.parse(storedAuthState));
    }
  }, []);

  const handleAuthentication = (isAuthenticated) => {
    setAuthenticated(isAuthenticated);
    localStorage.setItem('authenticated', JSON.stringify(isAuthenticated));
  };

  const handleLogout = () => {
    setAuthenticated(false);
    localStorage.removeItem('authenticated');
  };

  return (
    <div className="App">
      <BrowserRouter>
        <div>
          {authenticated && (
            <>
              <Link to="/events">Events</Link>{' '}
              <Link to="/tickets">Tickets</Link>{' '}
              <Link to="/ticketused">Check Ticket</Link>{' '}
              <Link to="/login" onClick={handleLogout}>Logout</Link>{' '}
            </>
          )}
          {!authenticated && <Link to="/login"></Link>}
          <Routes>
            {!authenticated && <Route path="/" element={<Navigate to="/login" />} />}
            <Route path="/events" element={<EventList />} />
            <Route path="/tickets" element={<TicketList />} />
            <Route path="/ticketused" element={<TicketUsed />} />
            <Route path="/login" element={<Login onAuthentication={handleAuthentication} />} />
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}
