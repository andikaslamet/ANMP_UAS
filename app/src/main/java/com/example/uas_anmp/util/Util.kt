package com.example.uas_anmp.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.uas_anmp.model.HobbyDatabase
import com.example.uas_anmp.model.UserDatabase

val DB_NAME = "userdb"
val HOBBY_DB_NAME = "hobbydb"

fun buildDB(context: Context):UserDatabase{
    val db = Room.databaseBuilder(context,
        UserDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}
fun buildHobbyDB(context: Context):HobbyDatabase{
    val db = Room.databaseBuilder(context,
        HobbyDatabase::class.java, HOBBY_DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}
val MIGRATION_1_2 = object: Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE user")
        database.execSQL("CREATE TABLE IF NOT EXISTS `user`")
        database.execSQL("ALTER TABLE hobby")
        database.execSQL("CREATE TABLE IF NOT EXISTS `hobby`")
    }

}
