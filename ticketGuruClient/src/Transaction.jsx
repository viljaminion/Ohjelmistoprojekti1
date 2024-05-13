import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const TransactionPage = () => {
    const [transaction, setTransaction] = useState(null);
    const [tickets, setTickets] = useState([]);
    const { id } = useParams();

    const username = localStorage.getItem('username') || '';
    const password = localStorage.getItem('password') || '';
    const basicAuth = btoa(`${username}:${password}`);

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return `${date.getMonth() + 1}/${date.getDate()}/${date.getFullYear()}, ${date.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit' })}`;
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const transactionResponse = await axios.get(`http://ohjelmistoprojekti1-ticketguru-kovas.rahtiapp.fi/transactions/${id}`, {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                });
                setTransaction(transactionResponse.data);

                const ticketsResponse = await axios.get('http://ohjelmistoprojekti1-ticketguru-kovas.rahtiapp.fi/tickets', {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                });
                setTickets(ticketsResponse.data.filter(ticket => ticket.transaction.id === parseInt(id)));
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, [id, basicAuth]);

    if (!transaction) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <style>
                {`
                table {
                    width: 70%;
                }
            `}
            </style>
            <h2>Transaction Complete</h2>
            <p>ID: {id}</p>
            <p>Date: {formatDate(transaction.transactiondate)}</p>
            <p>Total sum: <b>{transaction.ticketsum}€</b></p>
            <h2>Tickets sold:</h2>
            <table>
                <thead>
                    <tr>
                        <th>Ticket Type</th>
                        <th>Ticket Code</th>
                        <th>Event</th>
                        <th>Address</th>
                        <th>Showtime</th>
                    </tr>
                </thead>
                <tbody>
                    {tickets.map(ticket => (
                        <tr key={ticket.id}>
                            <td>{ticket.ticketType.tickettypename}</td>
                            <td>{ticket.ticketcode}</td>
                            <td>{ticket.ticketType.event.eventname}</td>
                            <td>{ticket.ticketType.event.address}</td>
                            <td>{formatDate(ticket.ticketType.event.showtime)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default TransactionPage;
