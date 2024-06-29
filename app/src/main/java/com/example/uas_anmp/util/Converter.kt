package com.example.uas_anmp.util

import androidx.room.TypeConverter

class Converter {

    //untuk mengkonversi dari array ke string
    @TypeConverter
    fun fromString(value: String): ArrayList<String> {
        return ArrayList(value.split(","))
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        return list.joinToString(",")
    }
}