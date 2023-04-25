package com.example.task1marvel.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task1marvel.repository.MarvelRepository
import com.example.task1marvel.ui.main.MarvelViewModel

class MarvelViewModelFactory(private val repository: MarvelRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarvelViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return MarvelViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
