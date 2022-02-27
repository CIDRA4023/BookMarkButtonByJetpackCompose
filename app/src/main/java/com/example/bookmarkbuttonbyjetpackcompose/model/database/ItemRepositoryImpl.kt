package com.example.bookmarkbuttonbyjetpackcompose.model.database

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val dao: ItemDAO
): ItemRepository {
    override suspend fun add(title: String): Item {
        val item = Item(title = title)
        dao.create(item)
        return item
    }

    override fun getAll(): Flow<List<Item>> {
        return dao.getAll()
    }

    // わからない
    override fun getById(itemId: Int): Flow<Item> {
        return dao.getById(itemId).take(1).map { list -> list[0]}
    }


}