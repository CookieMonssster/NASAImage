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

    fun fetchImages(query : String = ""){
        repository.getNasaImage(query)
            .subscribeBy (onSuccess = {
                onSuccess(it)
            }, onError = {
                //TODO
            })
    }

    private fun onSuccess(it: List<NasaImage>) {
        liveData.value = it
    }
}