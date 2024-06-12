package com.example.uas_anmp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.uas_anmp.util.AuthorConverter
import com.example.uas_anmp.util.Converter
import com.example.uas_anmp.util.MIGRATION_1_2


@Database(entities = arrayOf(Hobby::class), version = 2)
@TypeConverters(Converter::class,AuthorConverter::class)
abstract class HobbyDatabase: RoomDatabase() {
    abstract fun hobbyDao():HobbyDao

    companion object {
        @Volatile private var instance: HobbyDatabase ?= null
        private val LOCK = Any()

        fun buildHobbyDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HobbyDatabase::class.java,
                "hobbydb")
                .addMigrations(MIGRATION_1_2)
                .build()
        operator fun invoke(context: Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildHobbyDatabase(context).also {
                        instance = it
                    }
                }
            }
        }


    }
}