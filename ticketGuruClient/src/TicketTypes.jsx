// TicketTypesForEvent.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import axios for making HTTP requests
import { useParams } from 'react-router-dom'; // Import useParams to access URL parameters

const TicketTypesForEvent = () => {
    const { id } = useParams(); // Get the event ID from the URL
    const [ticketTypes, setTicketTypes] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    const username = localStorage.getItem('username') || '';
    const password = localStorage.getItem('password') || '';
    const basicAuth = btoa(`${username}:${password}`);

    useEffect(() => {
        const fetchTicketTypes = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/tickettypes`, {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                });
                console.log('API Response:', response.data); // Log the API response
                setTicketTypes(response.data);
                setIsLoading(false);
            } catch (error) {
                setError(error.message);
                setIsLoading(false);
            }
        };

        fetchTicketTypes();
    }, []);

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h2>Ticket Types for Event ID: {id}</h2>
            {ticketTypes.map(ticketType => {
                if (ticketType.event.id === parseInt(id)) {
                    return (
                        <div key={ticketType.id}>
                            <h3>{ticketType.tickettypename}</h3>
                            <p>Price: ${ticketType.price}</p>
                            <p>Event Name: {ticketType.event.eventname}</p>
                        </div>
                    );
                }
                return null;
            })}
        </div>
    );
};

export default TicketTypesForEvent;
