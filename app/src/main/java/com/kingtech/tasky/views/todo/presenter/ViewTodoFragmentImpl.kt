package com.kingtech.tasky.views.todo.presenter

import com.kingtech.tasky.R
import com.kingtech.tasky.data.RealmControllerImpl

class ViewTodoFragmentImpl(private val viewTodo: ViewTodo) {
	
	fun deleteTodo(id: Int) {
		RealmControllerImpl().deleteSingleTodo(id)
		viewTodo.showMessage("Task Deleted Successfully")
		viewTodo.navigate(R.id.todoFragment)
	}
}