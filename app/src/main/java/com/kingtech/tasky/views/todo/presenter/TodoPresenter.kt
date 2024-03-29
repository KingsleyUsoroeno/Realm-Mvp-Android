package com.kingtech.tasky.views.todo.presenter

import android.os.Bundle
import com.kingtech.tasky.data.RealmControllerImpl
import com.kingtech.tasky.views.ui.fragment.TodoView

class TodoPresenter(private val todoView: TodoView) {
	
	private val realmController = RealmControllerImpl()
	
	fun getAllSavedTodo() {
		val allTodo = realmController.getAllTodo()
		if (allTodo.size > 0) {
			todoView.setTodo(allTodo)
		} else {
			todoView.setTodo(null)
		}
	}
	
	fun navigate(destination: Int, arg: Bundle?) {
		todoView.navigate(destination, arg)
	}
}