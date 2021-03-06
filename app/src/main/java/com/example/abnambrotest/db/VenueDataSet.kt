package com.example.abnambrotest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.abnambrotest.ni.remote.response.search.Categories
import com.example.abnambrotest.ni.remote.response.search.Icon
import com.example.abnambrotest.ni.remote.response.search.Location
import com.example.abnambrotest.ni.remote.response.search.Venues

@Database(entities = [Venues::class,Location::class,Categories::class,Icon::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class VenueDataSet : RoomDatabase() {

    abstract fun venueDao(): IVenueDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: VenueDataSet? = null

        fun getDatabase(context: Context): VenueDataSet {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VenueDataSet::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}