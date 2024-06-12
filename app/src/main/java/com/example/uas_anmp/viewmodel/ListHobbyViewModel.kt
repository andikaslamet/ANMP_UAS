package com.example.uas_anmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.uas_anmp.model.Hobby
import com.example.uas_anmp.model.HobbyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListHobbyViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    val hobbyLD = MutableLiveData<List<Hobby>>()
    val todoLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()
    fun refresh() {
        loadingLD.value = true
        todoLoadErrorLD.value = false
        launch {
            val db = HobbyDatabase.buildHobbyDatabase(
                getApplication()
            )

            hobbyLD.postValue(db.hobbyDao().getAllHobbies())
            loadingLD.postValue(false)
        }
    }
    fun clearTask(hobby: Hobby) {
        launch {
            val db = HobbyDatabase.buildHobbyDatabase(
                getApplication()
            )
            db.hobbyDao().deleteHobby(hobby)

            hobbyLD.postValue(db.hobbyDao().getAllHobbies())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
}