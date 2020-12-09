package com.example.reignapp.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.reignapp.data.entity.*
import com.example.reignapp.data.local.db.dao.*

@Database(
    entities = [HitEntity::class, AuthorEntity::class, CommentTextEntity::class,
        StoryTitleEntity::class, StoryUrlEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ReignDatabase : RoomDatabase() {
    abstract fun HitDao(): HitDao
    abstract fun AuthorDao(): AuthorDao
    abstract fun CommentTextDao(): CommentTextDao
    abstract fun StoryTitleDao(): StoryTitleDao
    abstract fun StoryUrlDao(): StoryUrlDao

    companion object {
        private const val DATABASE_NAME = "REIGN_DATABASE"
        private var INSTANCE: ReignDatabase? = null

        fun getAppDatabase(context: Context): ReignDatabase? {
            if (INSTANCE == null) {
                synchronized(ReignDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ReignDatabase::class.java,
                            DATABASE_NAME
                    ).build()
                }
            }

            return INSTANCE
        }
    }
}