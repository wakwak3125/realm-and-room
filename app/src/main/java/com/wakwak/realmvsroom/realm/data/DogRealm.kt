package com.wakwak.realmvsroom.realm.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class DogRealm(@PrimaryKey var id: Int = -1, var name: String = "") : RealmObject()
