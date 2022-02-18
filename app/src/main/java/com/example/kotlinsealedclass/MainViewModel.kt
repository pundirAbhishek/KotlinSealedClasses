package com.example.kotlinsealedclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinsealedclass.repository.MainRepository
import com.example.kotlinsealedclass.services.network.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _fact = MutableLiveData<String>()
    private val fact: LiveData<String> = _fact

    fun search() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = MainRepository.search()
            if (response is NetworkResponse.Success) {
                _fact.postValue(response.data?.fact)
            }
            if (response is NetworkResponse.Failure) {
                // handle error
            }
        }
    }

    fun getFact(): LiveData<String> {
        return fact
    }
}