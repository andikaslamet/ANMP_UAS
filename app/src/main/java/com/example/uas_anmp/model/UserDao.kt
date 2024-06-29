package com.example.uas_anmp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: User)
    @Query("SELECT * FROM user")
    fun selectAllUser(): List<User>
    @Query("SELECT * FROM user WHERE uuid= :id")
    fun selectUserBYId(id:Int): User
    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun loginUser(username: String, password: String): User?
    @Query("SELECT * FROM user WHERE username = :username")
    fun checkUsername(username: String): User?
    @Delete
    fun deleteUser(user: User)
}
