package com.binarapps.android.nasaimage

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.binarapps.android.nasanetwork.repository.NasaRepository
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel: ViewModel(){

    private val repository = NasaRepository()

    fun fetchImages(){
        repository.getNasaImage("moon")
            .subscribeBy (onSuccess = {
                Log.d("MainViewModel(): ", it.toString())
            }, onError = {
                //TODO
            })
    }
}