package com.example.bookmarkbuttonbyjetpackcompose.model.database

import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun add(title: String): Item
    fun getAll(): Flow<List<Item>>
}