package com.kingtech.tasky.views.todo.presenter

import com.kingtech.tasky.R
import com.kingtech.tasky.data.RealmControllerImpl
import com.kingtech.tasky.views.todo.Validator
import com.kingtech.tasky.views.ui.fragment.UserView

class TodoFragmentImpl(private val userView: UserView, private var isEnabled: Boolean) {
	
	private val realmCtl = RealmControllerImpl()
	
	fun onSaveClicked() {
		val todo = userView.getTodo()
		val isOkayTobeSaved = Validator.validateUserInput(todo)
		if (!isOkayTobeSaved) {
			userView.showInputIsRequired()
		} else {
			realmCtl.saveTodo(todo)
			userView.showMsg("Task has been saved successfully")
			userView.navigateTo(R.id.action_addTodoFragment_to_todoFragment)
		}
	}
	
	fun setToggle() {
		if (isEnabled) {
			isEnabled = false
			userView.showDisabledReminder(isEnabled, R.color.primary_text)
			return
		}
		
		if (!isEnabled) {
			isEnabled = true
			userView.showEnabledReminder(isEnabled, R.color.colorPrimary)
			return
		}
	}
}