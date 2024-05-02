import React, { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import styled from "styled-components";
import NewEvent from './NewEvent';

const theme = {
    blue: {
        default: "#3f51b5",
        hover: "#283593",
    }
};

const Button = styled.button`
  background-color: ${(props) => theme[props.theme].default};
  color: white;
  padding: 5px 15px;
  border-radius: 5px;
  outline: 0;
  border: 0; 
  text-transform: uppercase;
  margin: 10px 0px;
  cursor: pointer;
  box-shadow: 0px 2px 2px lightgray;
  transition: ease background-color 250ms;
  &:hover {
    background-color: ${(props) => theme[props.theme].hover};
  }
  &:disabled {
    cursor: default;
    opacity: 0.7;
  }
`;

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

            
          {/*  <BrowserRouter>
                <div>
                <Link to="/newevent">Create new event</Link>{' '}

                <Routes>
                <Route path="/newevent" element={<NewEvent />} />
                </Routes>
                </div>
    </BrowserRouter> */}
            
            

             <a href="/newevent" class="btn btn-success">Create new event</a> 

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
                            <td>
                                <a th:href="@{/events/delete/{id}(id=${event.id})}" class="btn btn-danger">Delete</a>
                                <a th:href="@{/events/edit/{id}(id=${event.id})}" class="btn btn-primary">Edit</a>
                            </td>

                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default EventList;
