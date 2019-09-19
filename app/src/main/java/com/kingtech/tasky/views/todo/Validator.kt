package com.kingtech.tasky.views.todo

object Validator {
	
	fun validateUserInput(todo: Todo) : Boolean{
		return !(todo.name.isEmpty() || todo.desciption.isEmpty() || todo.priority == 0)
	}
}