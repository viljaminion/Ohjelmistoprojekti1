import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const EventList = () => {
    const [eventsWithTicketTypes, setEventsWithTicketTypes] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    const username = localStorage.getItem('username') || '';
    const password = localStorage.getItem('password') || '';
    const basicAuth = btoa(`${username}:${password}`);

    useEffect(() => {
        const fetchData = () => {
            Promise.all([
                fetch('http://ohjelmistoprojekti1-ticketguru-kovas.rahtiapp.fi/events', {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                }),
                fetch('http://ohjelmistoprojekti1-ticketguru-kovas.rahtiapp.fi/tickettypes', {
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
        axios.delete(`http://ohjelmistoprojekti1-ticketguru-kovas.rahtiapp.fi/event/${eventId}`, {
            headers: {
                Authorization: `Basic ${basicAuth}`
            }
        })
            .then(() => {
                setEventsWithTicketTypes(events => events.filter(event => event.id !== eventId));
            })
            .catch(error => {
                setError(error.message);
            });
    };

    const navigate = useNavigate();

    const handleEditEvent = (eventId) => {
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
            <h1>Events</h1>

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
                                <button onClick={() => navigate(`/tickettypes/${event.id}`)}>Ticket Types</button>
                                <button onClick={() => handleDeleteEvent(event.id)}>Delete</button>
                                <button onClick={() => handleEditEvent(event.id)}>Edit</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <button class="addbutton" onClick={() => navigate('/newevent')}>Add new event</button>{' '}
        </div>
    );
};

export default EventList;
