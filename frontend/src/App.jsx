import { useState } from 'react';

function App() {
    const [students, setStudents] = useState([]);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const getStudentData = async () => {
        const response = await fetch('http://localhost:8080/students');
        const data = await response.json();
        setStudents(data);
    };

    const login = async () => {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        });
        alert ("Login Successful");
    };

    return (
        <div>
            <button onClick={getStudentData}>
                Get Student Data
            </button>

            <h1>This is the student data:</h1>
            <ul>
                {students.map((student) => (
                    <li key={student.id}>
                        {student.name} - {student.course}
                    </li>
                ))}
            </ul>
      <input
        placeholder="Username"
        onChange={(e)=>
        setUsername(
            e.target.value
        )}/>

      <input
        placeholder="Password"
        onChange={(e)=>
        setPassword(
            e.target.value
        )}/>

      <button onClick={login}>Login</button>
    </div>
  );
       
}

export default App;