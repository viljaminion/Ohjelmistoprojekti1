import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SellTickets = () => {
    const [events, setEvents] = useState([]);
    const [selectedEvent, setSelectedEvent] = useState('');
    const [ticketTypes, setTicketTypes] = useState([]);
    const [selectedTicketTypeId, setSelectedTicketTypeId] = useState(null);
    const [quantity, setQuantity] = useState(1);
    const [shoppingCart, setShoppingCart] = useState([]);
    const [filteredTicketTypes, setFilteredTicketTypes] = useState([]);

    const username = localStorage.getItem('username') || '';
    const password = localStorage.getItem('password') || '';
    const basicAuth = btoa(`${username}:${password}`);

    useEffect(() => {
        const fetchEvents = async () => {
            try {
                const response = await axios.get('http://localhost:8080/events', {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                });
                setEvents(response.data);
            } catch (error) {
                console.error('Error fetching events:', error);
            }
        };

        fetchEvents();
    }, [basicAuth]);

    useEffect(() => {
        if (selectedEvent) {
            const fetchTicketTypes = async () => {
                try {
                    const response = await axios.get(`http://localhost:8080/tickettypes?eventId=${selectedEvent}`, {
                        headers: {
                            Authorization: `Basic ${basicAuth}`
                        }
                    });
                    setTicketTypes(response.data);
                } catch (error) {
                    console.error('Error fetching ticket types:', error);
                }
            };

            fetchTicketTypes();
        }
    }, [selectedEvent, basicAuth]);

    useEffect(() => {
        if (selectedEvent) {
            const filteredTypes = ticketTypes.filter((type) => type.event.id === parseInt(selectedEvent));
            setFilteredTicketTypes(filteredTypes);
        } else {
            setFilteredTicketTypes([]);
        }
    }, [selectedEvent, ticketTypes]);

    const handleEventChange = (event) => {
        setSelectedEvent(event.target.value);
        setSelectedTicketTypeId(null);
    };

    const handleTicketTypeChange = (event) => {
        const selectedId = parseInt(event.target.value);
        setSelectedTicketTypeId(selectedId);
    };

    const handleQuantityChange = (event) => {
        const newQuantity = parseInt(event.target.value);
        setQuantity(newQuantity);
    };

    const addToCart = (event) => {
        event.preventDefault();
        console.log(selectedTicketTypeId);
        const selectedTicket = ticketTypes.find((type) => type.id === selectedTicketTypeId);
        if (selectedTicket) {
            const itemsToAdd = Array.from({ length: quantity }, () => selectedTicket);
            setShoppingCart((prevCart) => [...prevCart, ...itemsToAdd]);
            setSelectedTicketTypeId(null);
            setQuantity(1);
        }
    };

    return (
        <div>
            <style>
                {`
                table {
                    width: 50%;
                }

                form div {
                    width: 15%;
                    margin: auto;
                    padding: 5px;
                }

                form select {
                    width: 100%;
                }

                label {
                    display: block;
                    text-align: left;
                }

                form input {
                    width: 96%;
                    align: left;
                }
            `}
            </style>
            <h1>Sell Tickets</h1>
            <form onSubmit={addToCart}>
                <div>
                    <label>Select an event:</label>
                    <select value={selectedEvent} onChange={handleEventChange}>
                        <option value="">-- Select Event --</option>
                        {events.map((event) => (
                            <option key={event.id} value={event.id}>
                                {event.eventname}
                            </option>
                        ))}
                    </select>
                </div>

                {selectedEvent && (
                    <>
                        <div>
                            <label>Select ticket type:</label>
                            <select value={selectedTicketTypeId} onChange={handleTicketTypeChange}>
                                <option value="">-- Ticket Types --</option>
                                {filteredTicketTypes.map((type) => (
                                    <option key={type.id} value={type.id}>
                                        {type.tickettypename} - {type.price}€
                                    </option>
                                ))}
                            </select>

                        </div>
                        <div>
                            <label>Amount of tickets:</label>
                            <input type="number" value={quantity} onChange={handleQuantityChange} min="1" />
                        </div>
                    </>
                )}

                <button class="addbutton" type="submit" disabled={!selectedTicketTypeId}>
                    Add to Cart
                </button>
            </form>

            <div>
                <h2>Shopping Cart</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Ticket Type</th>
                            <th>Event</th>
                            <th>Price</th>

                        </tr>
                    </thead>
                    <tbody>
                        {shoppingCart.map((type, index) => (
                            <tr key={index}>
                                <td>{type.tickettypename}</td>
                                <td>{type.event.eventname}</td>
                                <td>{type.price}€</td>

                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default SellTickets;
