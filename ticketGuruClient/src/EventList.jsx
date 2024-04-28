import React, { useState, useEffect } from 'react';

const EventList = () => {
    const [events, setEvents] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchData = () => {
            const username = 'mikko';
            const password = 'admin';
            const basicAuth = btoa(`${username}:${password}`);
            fetch('http://localhost:8080/events', {
                headers: {
                    Authorization: `Basic ${basicAuth}`
                }
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to fetch events');
                    }
                    return response.json();
                })
                .then(data => {
                    setEvents(data);
                    setIsLoading(false);
                })
                .catch(error => {
                    setError(error.message);
                    setIsLoading(false);
                });
        };

        fetchData();
    }, []);

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>Event List</h1>
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
                    </tr>
                </thead>
                <tbody>
                    {events.map(event => (
                        <tr key={event.id}>
                            <td>{event.id}</td>
                            <td>{event.eventname}</td>
                            <td>{event.address}</td>
                            <td>{new Date(event.showtime).toLocaleString()}</td>
                            <td>{event.description}</td>
                            <td>{event.maxtickets}</td>
                            <td>{event.duration}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default EventList;
