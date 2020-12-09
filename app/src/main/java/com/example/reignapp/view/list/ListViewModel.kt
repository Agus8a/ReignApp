package com.example.reignapp.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reignapp.data.HitRepository
import com.example.reignapp.data.model.Hit
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: HitRepository
) : ViewModel() {
    var hits = MutableLiveData<List<Hit>>()

    init {
        viewModelScope.launch {
            getHits()
        }
    }

    fun getHits() {
        viewModelScope.launch {
            getHitsFromDb()
        }
    }

    private suspend fun getHitsFromDb() {
        hits.value = repository.getHits()
    }

}