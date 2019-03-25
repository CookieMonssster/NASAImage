package com.binarapps.android.nasaimage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.binarapps.android.nasanetwork.repository.NasaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nasa = NasaRepository()

        val search = "earth"

        nasa.getNasaImage(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
            onSuccess = {
                Log.e("klop", "search for: $search, elements: ${it.size}")
                it.forEach { Log.e("klop", "title: ${it.title}") }
            },
            onError = { Log.e("klop", "some errors :( ${it.message}") }
        )

    }
}
