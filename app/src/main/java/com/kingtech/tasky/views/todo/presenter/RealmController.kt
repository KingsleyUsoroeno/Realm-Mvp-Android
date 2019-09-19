package com.kingtech.tasky.views.todo.presenter

import com.kingtech.tasky.views.todo.Todo
import io.realm.RealmResults


interface RealmController {
	
	fun saveTodo(todo: Todo)
	
	fun getLastInsertedRowId(rowId: Int): Long
	
	fun deleteSingleTodo(id: Int)
	
	fun getAllTodo(): RealmResults<Todo>
	
	fun getSingleTodo(id: Int): Todo?
	
	fun deleteTodo()
}