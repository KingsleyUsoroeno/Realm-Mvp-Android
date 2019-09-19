package com.kingtech.tasky.views.todo

import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Todo(
	@PrimaryKey var id: Int,
	@Required var name: String,
	var desciption: String,
	var priority: Int,
	var dueDate: String,
	@Ignore var reminder: Boolean = false // later feature
) : RealmObject() {
	constructor() : this(0, "", "",0, "", false)
}