import { useState } from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
//import 'react-table/react-table.css';
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import TicketList from './ticketList';
import EventList from './EventList';

export default function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <div>
          <Link to="/events">Events</Link>{' '}
          <Link to="/tickets">Tickets</Link>{' '}
          <Routes>

            <Route path="/events" element={<EventList />} />
            <Route path="/tickets" element={<TicketList />} />
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}
