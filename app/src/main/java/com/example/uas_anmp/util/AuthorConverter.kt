package com.example.uas_anmp.util

import androidx.room.TypeConverter
import com.example.uas_anmp.model.Hobby.Author

class AuthorConverter {
    //untuk mengkonversi dari sub class menjadi string
    @TypeConverter
    fun fromAuthor(author: Author): String {
        return "${author.nama},${author.email}"
    }

    @TypeConverter
    fun toAuthor(authorString: String): Author {
        val parts = authorString.split(",")
        return Author(parts[0], parts[1])
    }
}