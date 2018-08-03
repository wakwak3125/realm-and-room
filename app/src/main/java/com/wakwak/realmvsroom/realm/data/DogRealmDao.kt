package com.wakwak.realmvsroom.realm.data

import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.where

class DogRealmDao(private val realm: Realm) {

    fun insertDogs(vararg dog: DogRealm) {
        realm.executeTransaction { it.insertOrUpdate(dog.asList()) }
    }

    fun findDogsSortedByIdAsc(): RealmResults<DogRealm> {
        return realm.where<DogRealm>().findAll().sort("id", Sort.ASCENDING)
    }

    fun findDogsSortedByIdDesc(): RealmResults<DogRealm> {
        return realm.where<DogRealm>().findAll().sort("id", Sort.DESCENDING)
    }
}
