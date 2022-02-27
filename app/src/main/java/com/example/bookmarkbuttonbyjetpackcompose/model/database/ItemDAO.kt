package com.example.bookmarkbuttonbyjetpackcompose.model.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDAO {

    @Query("select * from item order by id")
    fun getAll(): Flow<List<Item>>

    @Query("select * from Item where id=:itemId limit 1")
    fun getById(itemId: Int): Flow<List<Item>>

    @Insert
    suspend fun create(todo: Item)

    @Update
    suspend fun update(todo: Item)

    @Delete
    suspend fun delete(todo: Item)

}