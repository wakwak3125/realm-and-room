package com.wakwak.realmvsroom.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs")
open class DogEntity(@PrimaryKey val id: Int, val name: String)
