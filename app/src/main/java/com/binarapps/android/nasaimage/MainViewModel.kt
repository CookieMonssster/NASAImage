package com.binarapps.android.nasaimage

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.binarapps.android.nasanetwork.model.NasaImage
import com.binarapps.android.nasanetwork.repository.NasaRepository
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel: ViewModel(){

    private val repository = NasaRepository()

    val liveData = MutableLiveData<List<NasaImage>>()

    fun fetchImages(){
        repository.getNasaImage("moon")
            .subscribeBy (onSuccess = {
                Log.d("MainViewModel(): ", it.toString())
                liveData.value = it
            }, onError = {
                //TODO
                Log.e("MainViewModel(): ", it.message)
            })
    }
}