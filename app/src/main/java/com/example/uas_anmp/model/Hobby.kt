package com.example.uas_anmp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hobby(
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0,

    @ColumnInfo(name = "judul")
    var judul: String,

    @ColumnInfo(name = "deskripsi_singkat")
    var deskripsi_singkat: String,

    var category: ArrayList<String>,

    var author: Author
) {
    data class Author(
        @ColumnInfo(name = "nama")
        var nama: String,
        @ColumnInfo(name = "email")
        var email: String
    )
}




