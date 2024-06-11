package com.example.uas_anmp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name="username")
    var username:String,
    @ColumnInfo(name="password")
    var password:String,
    @ColumnInfo(name="email")
    var email:String,
    @ColumnInfo(name="firstname")
    var firstname:String,
    @ColumnInfo(name="lastname")
    var lastname:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

