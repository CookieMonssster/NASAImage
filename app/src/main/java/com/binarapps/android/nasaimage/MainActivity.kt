package com.binarapps.android.nasaimage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.binarapps.android.nasanetwork.repository.NasaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchImages()
    }
}
