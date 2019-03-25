package com.binarapps.android.nasanetwork.repository

import com.binarapps.android.nasanetwork.model.NasaImage
import io.reactivex.Single

interface NasaRepositoryInterface {

    fun getNasaImage(query: String, mediaType: String = IMAGE): Single<List<NasaImage>>

    companion object {
        private const val IMAGE = "image"
    }
}