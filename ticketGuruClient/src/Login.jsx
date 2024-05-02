import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Login({ onAuthentication }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = () => {
        const basicAuth = btoa(`${username}:${password}`);

        fetch('http://localhost:8080/login', {
            method: 'GET',
            headers: {
                Authorization: `Basic ${basicAuth}`,
                'Content-Type': 'application/json',
            },
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to login');
                }
                localStorage.setItem('username', username);
                localStorage.setItem('password', password);
                onAuthentication(true);
                navigate('/');
            })
            .catch(error => {
                console.error('Login failed:', error);
            });
    };

    return (
        <div>
            <input type="text" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
            <br />
            <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <br />
            <button onClick={handleLogin}>Login</button>
        </div>
    );
}

export default Login;
