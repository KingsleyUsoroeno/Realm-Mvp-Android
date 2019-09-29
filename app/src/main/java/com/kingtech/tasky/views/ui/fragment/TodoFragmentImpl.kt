package com.kingtech.tasky.views.ui.fragment

import com.kingtech.tasky.R
import com.kingtech.tasky.views.todo.Validator
import com.kingtech.tasky.views.todo.presenter.RealmControllerImpl

class TodoFragmentImpl(private val userView: UserView, private var isEnabled: Boolean) {
	
	private val realmCtl = RealmControllerImpl()
	
	fun onSaveClicked() {
		val todo = userView.getTodo()
		val isOkayTobeSaved = Validator.validateUserInput(todo)
		if (!isOkayTobeSaved) {
			userView.showInputIsRequired()
		} else {
			realmCtl.saveTodo(todo)
			userView.showUserSavedMsg()
			userView.navigateTo(R.id.action_addTodoFragment_to_todoFragment)
		}
	}
	
	fun setToggle(): Boolean {
		if (isEnabled) {
			isEnabled = false
			userView.showEnabledReminder()
		} else {
			isEnabled = true
			userView.showDisabledReminder()
		}
		return isEnabled
	}
}