package com.binarapps.android.nasaimage

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.MainThread
import android.util.Log
import android.widget.Toast
import com.binarapps.android.nasanetwork.model.NasaImage
import com.binarapps.android.nasanetwork.repository.NasaRepository
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel: ViewModel(){

    private val repository = NasaRepository()

    val liveData = MutableLiveData<List<NasaImage>>()

    var result: Boolean = false

    fun fetchImages(userInput: String):Boolean{
        repository.getNasaImage(userInput)
            .subscribeBy (onSuccess = {
                result = !it.isEmpty()
                Log.d("MainViewModel(): ", it.toString())
                liveData.value = it
            }, onError = {
                Log.e("MainViewModel(): ", it.message)
            })
        return result
    }
}