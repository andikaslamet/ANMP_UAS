package com.example.uas_anmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.uas_anmp.model.Hobby
import com.example.uas_anmp.model.HobbyDatabase
import com.example.uas_anmp.util.buildHobbyDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailHobbyViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val hobbyLD = MutableLiveData<Hobby>()
    fun fetch(uuid:Int) {
        launch {
            val db = buildHobbyDB(getApplication())
            hobbyLD.postValue(db.hobbyDao().getHobbyByID(uuid))
        }
    }

    fun addHoby(list:List<Hobby>) {
        launch {
            val db = HobbyDatabase.buildHobbyDatabase(
                getApplication()
            )
            db.hobbyDao().insertHobby(*list.toTypedArray())
        }
    }



    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
}