package com.kingtech.tasky.base

import android.app.Application
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kingtech.tasky.common.Common
import com.kingtech.tasky.data.RealmControllerImpl
import io.realm.Realm
import io.realm.RealmConfiguration


class App : Application() {
	
	private lateinit var gson: Gson
	private lateinit var builder: GsonBuilder
	
	override fun onCreate() {
		super.onCreate()
		Realm.init(this)
		builder = GsonBuilder()
		gson = builder.create()
		val realmConfiguration = RealmConfiguration.Builder()
			.deleteRealmIfMigrationNeeded()
			.build()
		Realm.setDefaultConfiguration(realmConfiguration)
		startReminderNotification()
	}
	
	
	private fun startReminderNotification() {
		val realmController = RealmControllerImpl()
		realmController.getAllTodo().forEach {
			if (Common.compareDates(it.dueDate)) {
				Toast.makeText(
					this,
					"Should Show a User Some Sort of Notifcation here",
					Toast.LENGTH_LONG
				).show()
			} else {
				Toast.makeText(this, "No Match", Toast.LENGTH_LONG).show()
				
			}
		}
	}
	
	
	
}
