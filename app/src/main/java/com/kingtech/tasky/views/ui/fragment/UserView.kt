package com.kingtech.tasky.views.ui.fragment

import com.kingtech.tasky.data.model.Todo

interface UserView {
	
	fun getTodo(): Todo
	
	fun showInputIsRequired()
	
	fun getStringResourceArray(): List<String>
	
	fun showMsg(msg: String)
	
	fun navigateTo(destination: Int)
	
	fun showEnabledReminder(isEnabled: Boolean, color: Int)
	
	fun showDisabledReminder(isEnabled: Boolean, color: Int)
}