import React, { useState, useEffect, Button } from 'react';
import ReactTable from 'react-table-6';
import 'react-table-6/react-table.css';

export default function ticketList() {

    const [tickets, setTickets] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchData = () => {
            const username = 'mikko';
            const password = 'admin';
            const basicAuth = btoa(`${username}:${password}`);
            fetch('http://localhost:8080/tickets', {
                headers: {
                    Authorization: `Basic ${basicAuth}`
                }
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to fetch tickets');
                    }
                    return response.json();
                })
                .then(data => {
                    setTickets(data);
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
            <h1>Ticket List</h1>
            <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Used</th>
                    <th>Transaction date</th>
                    <th>Ticket type</th>
                    <th>Ticket Code</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                    {tickets.map(ticket => (
                        <tr key ={ticket.id}>
                            <td>{ticket.id}</td>
                            <td>{ticket.used}</td>
                            <td>{ticket.transaction.transactiondate}</td>
                            <td>{ticket.ticketType.tickettypename}</td>
                            <td>{ticket.ticketcode}</td>
                        </tr>
                    ))}
                
                
                </tbody>
            </table>
        </div>
    );

}