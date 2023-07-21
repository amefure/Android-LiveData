package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private val my_counter: MutableLiveData<Int> = MutableLiveData<Int>(0)

    val count:LiveData<Int> = my_counter

    fun plus(){
        val counter = my_counter.value ?: throw Exception("Invalid _count value")
        my_counter.value = counter + 1
    }
}