package com.example.oroutines_timer_stopwatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

internal class MainViewModel(repository: Repository = Repository()) : ViewModel() {

    val liveData: LiveData<Data> = repository.userData.asLiveData()

}