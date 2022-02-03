package com.example.bookmarkbuttonbyjetpackcompose.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmarkbuttonbyjetpackcompose.model.database.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    val itemList = repository.getAll()

    fun addItem(title: String) {
        viewModelScope.launch {
            repository.add(title)

        }
    }
}