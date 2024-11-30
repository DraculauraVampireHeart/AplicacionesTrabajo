package com.example.ejemploenclase1.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemploenclase1.data.model.ServiceEntity
import com.example.ejemploenclase1.data.model.dao.ServiceDao

@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
}