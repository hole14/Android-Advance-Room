package com.example.mynoteappsroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    companion object{
        @Volatile
        private var INSTANSE: NoteRoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): NoteRoomDatabase {
            if (INSTANSE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    INSTANSE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database"
                    )
                        .build()
                }
            }
            return INSTANSE as NoteRoomDatabase
        }

    }
}