package com.wakwak.realmvsroom

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wakwak.realmvsroom.realm.data.DogRealm
import com.wakwak.realmvsroom.realm.data.DogRealmDao
import com.wakwak.realmvsroom.room.data.DogEntity
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val room = (application as MyApplication).db
        val dogs = mutableListOf<DogEntity>()
        val dogRealms = mutableListOf<DogRealm>()
        for (i in 0..9999) {
            dogRealms.add(DogRealm(i, "DOG$i"))
            dogs.add(DogEntity(i, "DOG$i"))
        }

        bench({
            room.dogStore().insertDogs(*dogs.toTypedArray())
        }, "room_insert")
        bench({
            DogRealmDao(it).insertDogs(*dogRealms.toTypedArray())
        }, "realm_insert")
        bench({
            room.dogStore().findDogsSortedByIdAsc()
            room.dogStore().findDogsSortedByIdDesc()
        }, "room_sort_asc_desc")
        bench({
            DogRealmDao(it).findDogsSortedByIdAsc()
            DogRealmDao(it).findDogsSortedByIdDesc()
        }, "realm_sort_asc_desc")
    }

    private fun bench(cb: (realm: Realm) -> Unit, tag: String) {
        Thread(Runnable {
            val start = System.currentTimeMillis()
            cb.invoke(Realm.getDefaultInstance())
            val end = System.currentTimeMillis()
            Log.d("MainActivity", "$tag:${(end - start)}ms")
        }).start()
    }
}
