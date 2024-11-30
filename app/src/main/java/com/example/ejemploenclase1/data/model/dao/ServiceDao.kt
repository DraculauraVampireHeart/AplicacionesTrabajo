package com.example.ejemploenclase1.data.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.ejemploenclase1.data.model.ServiceEntity


@Dao
interface ServiceDao {
    @Query("SELECT * FROM ServiceEntity")
    fun getAll(): List<ServiceEntity>
    @Query("SELECT * FROM ServiceEntity WHERE id = :ServiceId")
    fun show(ServiceId: Int): ServiceEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(services: List<ServiceEntity>)
    @Delete
    fun delete(service: ServiceEntity)

    @Query("SELECT MAX(id) FROM ServiceEntity")
    fun lastId(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(service: ServiceEntity)
}