package com.example.bookmarkbuttonbyjetpackcompose.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDAO
}