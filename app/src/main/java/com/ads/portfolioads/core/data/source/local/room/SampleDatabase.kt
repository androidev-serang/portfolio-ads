package com.ads.portfolioads.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ads.portfolioads.core.data.source.local.entity.SampleEntity

/**
 * Created by FAJAR SEPTIAN on 21/10/20.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
abstract class SampleDatabase : RoomDatabase() {

    abstract fun sampleDao(): SampleDao

    companion object {
        @Volatile
        private var INSTANCE: SampleDatabase? = null

        fun getInstance(context: Context): SampleDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SampleDatabase::class.java,
                    "sample.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}