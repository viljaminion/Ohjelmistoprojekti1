import React, { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link, useParams, useNavigate } from 'react-router-dom';
import styled from "styled-components";
import NewEvent from './NewEvent';
import TicketTypes from './TicketTypes';
import EditEvent from './EditEvent';

const EventList = () => {
    const [eventsWithTicketTypes, setEventsWithTicketTypes] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchData = () => {
            const username = 'mikko';
            const password = 'admin';
            const basicAuth = btoa(`${username}:${password}`);
            Promise.all([
                fetch('http://localhost:8080/events', {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                }),
                fetch('http://localhost:8080/tickettypes', {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                })
            ])
                .then(([eventsResponse, ticketTypesResponse]) => {
                    if (!eventsResponse.ok || !ticketTypesResponse.ok) {
                        throw new Error('Failed to fetch data');
                    }
                    return Promise.all([eventsResponse.json(), ticketTypesResponse.json()]);
                })
                .then(([eventsData, ticketTypesData]) => {
                    // Combine events with their corresponding ticket types
                    const eventsWithTypes = eventsData.map(event => ({
                        ...event,
                        ticketTypes: ticketTypesData.filter(ticket => ticket.event.id === event.id)
                    }));
                    setEventsWithTicketTypes(eventsWithTypes);
                    setIsLoading(false);
                })
                .catch(error => {
                    setError(error.message);
                    setIsLoading(false);
                });
        };

        fetchData();
    }, []);

    const handleDeleteEvent = (eventId) => {
        // Implement delete event functionality
    };

    const navigate = useNavigate(); // Use useNavigate hook

    const handleEditEvent = (eventId) => {
        // Redirect to the EditEvent page with the event ID in the URL
        navigate(`/editevent/${eventId}`);
    };

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>Event List</h1>
            <Link to="/newevent">Create new event</Link>{' '}
            <Routes>
                {eventsWithTicketTypes.map(event => (
                    <Route key={event.id} path={`/tickettypes/${event.id}`} element={<TicketTypes event={event} />} />
                ))}
            </Routes>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Event Name</th>
                        <th>Address</th>
                        <th>Showtime</th>
                        <th>Description</th>
                        <th>Max Tickets</th>
                        <th>Duration</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {eventsWithTicketTypes.map(event => (
                        <tr key={event.id}>
                            <td>{event.id}</td>
                            <td>{event.eventname}</td>
                            <td>{event.address}</td>
                            <td>{new Date(event.showtime).toLocaleString()}</td>
                            <td>{event.description}</td>
                            <td>{event.maxtickets}</td>
                            <td>{event.duration}</td>
                            <td>
                                <Link to={`/tickettypes/${event.id}`}>
                                    <button>Ticket Types</button>
                                </Link>
                                <button onClick={() => handleDeleteEvent(event.id)}>Delete</button>
                                <button onClick={() => handleEditEvent(event.id)}>Edit</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default EventList;
