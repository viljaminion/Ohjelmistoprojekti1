import React, { useState, useEffect } from 'react';
import styled from "styled-components";
import axios from 'axios';

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

export default function NewEvent() {

    const [eventname, setEventname] = useState('Event name');
    const [address, setAddress] = useState('Address');
    const [showtime, setShowtime] = useState('');
    const [description, setDescription] = useState('Description');
    const [maxtickets, setMaxtickets] = useState(1);
    const [duration, setDuration] = useState(1);

    const username = 'mikko';
    const password = 'admin';
    const basicAuth = btoa(`${username}:${password}`);

    const handleNewEvent = async () => {
        try {
          await axios.post(
            'http://localhost:8080/events',
            {
              eventname,
              address,
              showtime,
              description,
              maxtickets,
              duration
            },
            {
              headers: {
                Authorization: `Basic ${basicAuth}`
              }
            }
          );
          alert('Event created successfully!');
        } catch (error) {
          console.error('Error creating data:', error);
        }
      };

      return (
        <div>
          <h2>Create new event</h2>
          <input
            type="text"
            value={eventname}
            onChange={(e) => setEventname(e.target.value)}
          />
          <input
            type="text"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
          <input
            type="datetime-local"
            value={showtime}
            onChange={(e) => setShowtime(e.target.value)}
          />
          <input
          type="text"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          />
          <input
          type="number"
          value={maxtickets}
          onChange={(e) => setMaxtickets(e.target.value)}
          />
          <input
          type="number"
          value={duration}
          onChange={(e) => setDuration(e.target.value)}
          />
          <button onClick={handleNewEvent}>Create new event</button>
        </div>
      );
}