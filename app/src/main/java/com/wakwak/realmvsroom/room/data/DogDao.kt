package com.wakwak.realmvsroom.room.data

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDogs(vararg dogs: DogEntity)

    @Query("SELECT * FROM dogs ORDER BY id ASC")
    fun findDogsSortedByIdAsc(): Cursor

    @Query("SELECT * FROM dogs ORDER BY id DESC")
    fun findDogsSortedByIdDesc(): Cursor
}
