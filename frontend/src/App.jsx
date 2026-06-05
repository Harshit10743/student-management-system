import { useState } from 'react';
function App() {

    const [students, setStudents] = useState({});
    const getStudentData = async () => {
        const response = await fetch('http://localhost:8080/students');
        const data = await response.json();
        setStudents(data);
    }

    return (
        <div>
            <button onClick={getStudentData}>
                Get Student Data
            </button>
            <h1> This is the student data:</h1>
            <h2> {students.name}</h2>
            <h2> {students.course}</h2>
            <h2> {students.id}</h2>
        </div>
    );
}

export default App;