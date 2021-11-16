package com.example.koo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koo.network.RetroInstance
import com.example.koo.network.RetroService
import com.example.koo.model.RecyclerList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    var recyclerListLiveData : MutableLiveData<RecyclerList> = MutableLiveData()

    fun getRecyclerListObserver(): MutableLiveData<RecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response  = retroInstance.getDataFromApi()
            recyclerListLiveData.postValue(response)
        }
    }
}