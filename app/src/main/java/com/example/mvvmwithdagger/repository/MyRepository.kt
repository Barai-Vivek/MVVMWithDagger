package com.example.mvvmwithdagger.repository

import com.example.mvvmwithdagger.model.People

class MyRepository {

    private val dataSet: ArrayList<People> = ArrayList()

    suspend fun getAllItems(): List<People> {
        // Perform network or database call to get items
        // Example: return apiService.getAllItems()
        return dataSet
    }

    suspend fun insertItem(item: People) {
        // Perform network or database call to insert item
        // Example: apiService.insertItem(item)
        dataSet.add(dataSet.size, item)
    }

    suspend fun updateItem(item: People) {
        // Perform network or database call to update item
        // Example: apiService.updateItem(item)
    }

    suspend fun deleteItem(item: People) {
        // Perform network or database call to delete item
        // Example: apiService.deleteItem(item.id)
    }
}
