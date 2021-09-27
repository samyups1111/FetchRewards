package com.sammydj.fetchrewards.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sammydj.fetchrewards.model.ItemLocal

@Database(entities = [ItemLocal::class], version = 1, exportSchema = false)

abstract class MainDatabase: RoomDatabase() {
    abstract val mainDao : MainDao

    companion object {
        @Volatile
        private var INSTANCE : MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "MainDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}