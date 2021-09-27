package com.sammydj.fetchrewards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository): ViewModel() {

    init {
        viewModelScope.launch { repository.getItemsFromNetwork() } // Using Coroutine for Async
    }

    val itemsInDatabase = repository.getItemsFromDatabase() // Don't need Coroutine for LiveData

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            repository.clearDatabase()
        }
    }

    class MainViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}