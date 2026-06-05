import { useState } from 'react';

function App() {
    const [students, setStudents] = useState([]);

    const getStudentData = async () => {
        const response = await fetch('http://localhost:8080/students');
        const data = await response.json();
        setStudents(data);
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
        </div>
    );
}

export default App;