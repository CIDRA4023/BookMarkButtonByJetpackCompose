package com.example.bookmarkbuttonbyjetpackcompose.ui.detail

import androidx.lifecycle.ViewModel
import com.example.bookmarkbuttonbyjetpackcompose.model.database.Item
import com.example.bookmarkbuttonbyjetpackcompose.model.database.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val itemId = MutableStateFlow(-1)

    // flatMapLatestとは
    val item: Flow<Item> = itemId.flatMapLatest { itemId -> repository.getById(itemId) }


    fun setId(itemId: Int) {
        this.itemId.value = itemId
    }
}