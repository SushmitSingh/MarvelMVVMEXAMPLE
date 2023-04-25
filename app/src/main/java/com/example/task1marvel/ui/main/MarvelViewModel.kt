package com.example.task1marvel.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.task1marvel.data.Marvel
import com.example.task1marvel.repository.MarvelRepository

class MarvelViewModel(private val repository: MarvelRepository) : ViewModel() {
    //Get the data from the repository
    //Returning a LiveData object so that the data can be observed
    fun getMarvelData(): LiveData<List<Marvel>> {
        return repository.getMarvelData()
    }
}