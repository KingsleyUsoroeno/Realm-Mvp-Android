package com.kingtech.tasky.base

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.realm.Realm
import io.realm.RealmConfiguration


class App : Application(){

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
    }
}
