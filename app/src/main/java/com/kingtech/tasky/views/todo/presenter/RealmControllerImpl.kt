package com.kingtech.tasky.views.todo.presenter

import com.kingtech.tasky.views.todo.Todo
import io.realm.Realm
import io.realm.RealmResults


class RealmControllerImpl : RealmController {
	
	private val realm = Realm.getDefaultInstance()
	
	override fun saveTodo(todo: Todo) {
		realm.beginTransaction()
		realm.copyToRealm(todo)
		realm.commitTransaction()
	}
	
	override fun getLastInsertedRowId(rowId: Int): Long {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	
	override fun deleteTodo() {
		realm.beginTransaction()
		realm.delete(Todo::class.java)
		realm.commitTransaction()
	}
	
	override fun deleteSingleTodo(id: Int) {
		val todoToDelete = realm.where(Todo::class.java).equalTo("id", id).findFirst()
		if (!realm.isInTransaction) {
			realm.beginTransaction()
			todoToDelete?.deleteFromRealm()
			realm.commitTransaction()
		}
	}
	
	// Return all Todos
	override fun getAllTodo(): RealmResults<Todo> {
		return realm.where(Todo::class.java).findAll()
	}
	
	//query a single item with the given id
	override fun getSingleTodo(id: Int): Todo? {
		return realm.where(Todo::class.java).equalTo("id", id).findFirst()
	}
	
	
}