package com.kingtech.tasky.views.todo

import com.kingtech.tasky.data.model.Todo

object Validator {
	
	fun validateUserInput(todo: Todo) : Boolean{
		return !(todo.name.isEmpty() || todo.desciption.isEmpty() || todo.priority == 0)
	}
}