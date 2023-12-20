package com.example.mvvmwithdagger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithdagger.model.People
import com.example.mvvmwithdagger.repository.MyRepository
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository) : ViewModel() {

    private val _items = MutableLiveData<List<People>>()
    val items: LiveData<List<People>> get() = _items

    init {
        // Initialize or load data
        viewModelScope.launch {
            _items.value = repository.getAllItems()
        }
    }

    fun insertItem(item: People) {
        viewModelScope.launch {
            repository.insertItem(item)
            _items.value = repository.getAllItems()
        }
    }

    fun updateItem(item: People) {
        viewModelScope.launch {
            repository.updateItem(item)
            _items.value = repository.getAllItems()
        }
    }

    fun deleteItem(item: People) {
        viewModelScope.launch {
            repository.deleteItem(item)
            _items.value = repository.getAllItems()
        }
    }
}
