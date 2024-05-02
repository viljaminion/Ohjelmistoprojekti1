
import { useState } from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
//import 'react-table/react-table.css';
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import TicketList from './ticketList';
import EventList from './EventList';
import TicketUsed from './TicketUsed';
import NewEvent from './NewEvent';

export default function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <div>
          <Link to="/events">Events</Link>{' '}
          <Link to="/tickets">Tickets</Link>{' '}
          <Link to="/ticketused">Check Ticket</Link>{' '}
          <Link to="/newevent">Create new event</Link>
          <Routes>

            <Route path="/events" element={<EventList />} />
            <Route path="/tickets" element={<TicketList />} />
            <Route path="/ticketused" element={<TicketUsed />} />
            <Route path="/newevent" element={<NewEvent />} />
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}
