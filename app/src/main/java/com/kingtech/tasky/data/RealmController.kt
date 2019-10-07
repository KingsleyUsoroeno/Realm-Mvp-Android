package com.kingtech.tasky.data

import com.kingtech.tasky.data.model.Todo
import io.realm.RealmResults


interface RealmController {
	
	fun saveTodo(todo: Todo)
	
	fun getLastInsertedRowId(rowId: Int): Long
	
	fun deleteSingleTodo(id: Int)
	
	fun getAllTodo(): RealmResults<Todo>
	
	fun getSingleTodo(id: Int): Todo?
	
	fun deleteTodo()
}