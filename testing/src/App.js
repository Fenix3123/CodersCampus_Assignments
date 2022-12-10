import React from 'react';
import Header from './components/header'
import Tasks from './components/Tasks'
import AddTask from './components/AddTask'
import {useState} from 'react';

function App(){
	const [showAddTask, setShowAddTask] = useState(false)
	const [tasks, setTasks] = useState([
			{
				id: 1,
				text: 'doctors appointment',
				day: 'Feb 5th at 2:30pm',
				reminder: true,
			},
			{
				id: 2,
				text: 'Meeting at school',
				day: 'Feb 6th at 3:30pm',
				reminder: true,
			},
			{
				id: 3,
				text: 'Shopping',
				day: 'Feb 5th at 1:30pm',
				reminder: true,
			}
		])
		
	//add Task
	function addTask(task){
		const id = Math.floor(Math.random() * 10000) + 1
		const newTask = {id, ...task}
		setTasks([...tasks, newTask])
	}
	//Delete Task
	function deleteTask(id){
		setTasks(tasks.filter((task) => task.id !== id))
	}
	
	//toggle reminder
	function toggleReminder(id){
		setTasks(tasks.map((task) => task.id === id ? {...task, reminder:!task.reminder} : task)
		)
	}
	
	return(
		<div className='container'>
		 <Header onAdd={() => setShowAddTask(!showAddTask)}/>
		 {showAddTask && <AddTask addTask={addTask}/>}
		 {tasks.length > 0 ? <Tasks tasks={tasks} onDelete={deleteTask} onToggle={toggleReminder}/> : "No tasks to show"}
		</div>
	)
}




export default App;