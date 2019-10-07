package com.kingtech.tasky.views.ui.fragment

import android.os.Bundle
import com.kingtech.tasky.data.model.Todo
import io.realm.RealmResults

interface TodoView {
	
	fun setTodo(todo: RealmResults<Todo>?)
	
	fun navigate(destination: Int, arg: Bundle?)
}