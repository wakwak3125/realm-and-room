package com.wakwak.realmvsroom

import android.app.Application
import androidx.room.Room
import io.realm.Realm

class MyApplication : Application() {

    lateinit var db: AppDatabase
    lateinit var realm: Realm

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        realm = Realm.getDefaultInstance()
        db = Room.databaseBuilder<AppDatabase>(this, AppDatabase::class.java, "db").build()
    }
}
