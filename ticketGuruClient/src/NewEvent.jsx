import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function NewEvent() {

  const [eventname, setEventname] = useState('');
  const [address, setAddress] = useState('');
  const [showtime, setShowtime] = useState('');
  const [description, setDescription] = useState('');
  const [maxtickets, setMaxtickets] = useState('');
  const [duration, setDuration] = useState('');

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

                label {
                    display: block;
                    text-align: left;
                }

                input {
                    width: 100%;
                }
            `}
      </style>
      <h2>Add new event</h2>
      <form onSubmit={handleNewEvent}>
        <div>
          <label>Event name:</label>
          <input
            type="text"
            value={eventname}
            onChange={(e) => setEventname(e.target.value)}
          />
        </div>
        <div>
          <label>Address:</label>
          <input
            type="text"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
        </div>
        <div>
          <label>Date & Time:</label>
          <input
            type="datetime-local"
            value={showtime}
            onChange={(e) => setShowtime(e.target.value)}
          />
        </div>
        <div>
          <label>Description:</label>
          <input
            type="text"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </div>
        <div>
          <label>Max tickets:</label>
          <input
            type="number"
            value={maxtickets}
            onChange={(e) => setMaxtickets(e.target.value)}
          />
        </div>
        <div>
          <label>Duration:</label>
          <input
            type="number"
            value={duration}
            onChange={(e) => setDuration(e.target.value)}
          />
        </div>
        <button class="addbutton" type="submit">Add event</button>
      </form>
    </div>
  );
}