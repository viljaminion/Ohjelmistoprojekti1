import React, { useState } from 'react';

const TicketUsed = () => {
    const [ticketCode, setTicketCode] = useState('');
    const [ticket, setTicket] = useState(null);
    const [error, setError] = useState(null);

    const username = 'mikko';
    const password = 'admin';
    const basicAuth = btoa(`${username}:${password}`);

    const handleInputChange = (event) => {
        setTicketCode(event.target.value);
    };

    const handleSearch = () => {
        fetch(`http://localhost:8080/tickets?ticketcode=${ticketCode}`, {
            headers: {
                Authorization: `Basic ${basicAuth}`
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Ticket not found');
                }
                return response.json();
            })
            .then(data => {
                if (data.length === 0) {
                    throw new Error('Ticket not found');
                }
                setTicket(data[0]);
            })
            .catch(error => {
                setError(error.message);
            });
    };

    const handleMarkAsUsed = () => {
        fetch(`http://localhost:8080/tickets/${ticket.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Basic ${basicAuth}`
            },
            body: JSON.stringify({ used: new Date().toISOString() })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to mark ticket as used');
                }
                return response.json();
            })
            .then(data => {
                setTicket(data);
            })
            .catch(error => {
                setError(error.message);
            });
    };

    return (
        <div>
            <h1>Ticket Search</h1>
            <input
                type="text"
                value={ticketCode}
                onChange={handleInputChange}
                placeholder="Enter Ticket Code"
            />
            <button onClick={handleSearch}>Search</button>
            {ticket && (
                <div>
                    <h2>Ticket Details</h2>
                    <p>Ticket Code: {ticket.ticketcode}</p>
                    <p>Used: {ticket.used ? new Date(ticket.used).toLocaleString() : 'Not Used'}</p>
                    <button onClick={handleMarkAsUsed}>Mark as Used</button>
                </div>
            )}
            {error && <p>{error}</p>}
        </div>
    );
};

export default TicketUsed;
