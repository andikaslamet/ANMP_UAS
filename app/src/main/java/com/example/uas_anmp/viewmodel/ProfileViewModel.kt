package com.example.uas_anmp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_anmp.model.User
import com.example.uas_anmp.model.UserDao
import kotlinx.coroutines.launch

class ProfileViewModel(private val userDao: UserDao) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUserByUsername(username: String) {
        viewModelScope.launch {
            _user.value = userDao.checkUsername(username)
        }
    }
}