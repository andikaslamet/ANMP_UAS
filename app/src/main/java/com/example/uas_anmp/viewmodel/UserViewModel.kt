package com.example.uas_anmp.viewmodel

    import android.app.Application
    import android.widget.Toast
    import androidx.lifecycle.AndroidViewModel
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.viewModelScope
    import com.example.uas_anmp.model.User
    import com.example.uas_anmp.model.UserDao
    import com.example.uas_anmp.model.UserDatabase
import com.example.uas_anmp.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
    import kotlinx.coroutines.withContext
    import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    fun addUser(user: User) {
        viewModelScope.launch {
            val db = buildDB(getApplication())
            val check = withContext(Dispatchers.IO) {
                db.userDao().checkUsername(user.username)
            }
            withContext(Dispatchers.Main) {
                if (check != null) {
                    Toast.makeText(getApplication(), "Username sudah terpakai", Toast.LENGTH_SHORT).show()
                } else {
                    withContext(Dispatchers.IO) {
                        db.userDao().insertAll(user)
                    }
                    Toast.makeText(getApplication(), "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //fun addUser(user: User) {
      //  launch {
        //    val db = buildDB(getApplication())
          //  db.userDao().insertAll(user)
        //}
    //}
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean>
        get() = _loginSuccess
    fun login(username: String, password: String) {
        viewModelScope.launch {
            val db = buildDB(getApplication())
            val user = withContext(Dispatchers.IO) {
                db.userDao().loginUser(username, password)
            }
            if (user != null) {
                // Handle successful login
                _loginSuccess.value = true
            } else {
                // Handle login failure
                _loginSuccess.value = false
            }
        }
    }



    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
}