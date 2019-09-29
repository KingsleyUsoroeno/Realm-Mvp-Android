package com.kingtech.tasky.views.todo

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Todo(
	@PrimaryKey var id: Int,
	@Required var name: String,
	var desciption: String,
	var priority: Int,
	var cat: String,
	var dueDate: String,
	@Ignore var reminder: Boolean = false // later feature
) : RealmObject(), Parcelable {
	constructor() : this(0, "", "", 0, "", "")
}