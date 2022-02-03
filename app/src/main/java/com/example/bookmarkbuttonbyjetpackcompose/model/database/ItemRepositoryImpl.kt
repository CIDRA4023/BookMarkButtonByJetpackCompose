package com.example.bookmarkbuttonbyjetpackcompose.model.database

import kotlinx.coroutines.flow.Flow
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


}