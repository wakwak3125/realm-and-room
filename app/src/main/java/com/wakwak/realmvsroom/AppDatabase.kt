package com.wakwak.realmvsroom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wakwak.realmvsroom.room.data.DogDao
import com.wakwak.realmvsroom.room.data.DogEntity

@Database(entities = [(DogEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogStore(): DogDao
}
