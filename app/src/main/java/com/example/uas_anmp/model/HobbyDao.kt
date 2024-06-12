package com.example.uas_anmp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HobbyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHobby(vararg hobby: Hobby)

    @Query("SELECT * FROM Hobby")
    fun getAllHobbies(): List<Hobby>

    @Query("SELECT * FROM hobby WHERE uuid = :id")
    fun getHobbyByID(id:Int): Hobby
    @Delete
    fun deleteHobby(hobby: Hobby)

}
