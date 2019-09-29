package com.kingtech.tasky.views.ui.fragment

import com.kingtech.tasky.views.todo.Todo

interface UserView {
	
	fun getTodo(): Todo
	
	fun showUserNotSavedMessage()
	
	fun showInputIsRequired()
	
	fun getStringResourceArray(): List<String>
	
	fun showUserSavedMsg()
	
	fun navigateTo(destination: Int)
	
	fun showEnabledReminder()
	
	fun showDisabledReminder()
}