package com.example.uas_anmp.viewmodel

import android.content.Context
import android.provider.ContactsContract.Profile
import com.example.uas_anmp.model.User

class SharedPreference(context: Context) {
    companion object {
        const val SP_NAME = "profile_pref"
        const val NAME = "name"
        const val PASSWORD = "password"
        const val EMAIL = "email"
        const val FIRSTNAME = "firstname"
        const val LASTNAME = "lastname"
    }

    private val preference = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun setProfile(profile: User) {
        val prefEditor = preference.edit()
        prefEditor.putString(NAME, profile.username)
        prefEditor.putString(PASSWORD, profile.password)
        prefEditor.putString(EMAIL, profile.email)
        prefEditor.putString(FIRSTNAME, profile.firstname)
        prefEditor.putString(LASTNAME, profile.lastname)
        prefEditor.apply()
    }

    fun getProfile(): User {
        return User(
            username = preference.getString(NAME, "") ?: "",
            password = preference.getString(PASSWORD, "") ?: "",
            email = preference.getString(EMAIL, "") ?: "",
            firstname = preference.getString(FIRSTNAME, "") ?: "",
            lastname = preference.getString(LASTNAME, "") ?: ""
        )
    }
    fun clearProfile() {
        val prefEditor = preference.edit()
        prefEditor.clear()
        prefEditor.apply()
    }

}