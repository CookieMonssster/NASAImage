package com.binarapps.android.nasanetwork.repository

import com.binarapps.android.nasanetwork.model.NasaImage
import io.reactivex.Single

interface NasaRepository {

    fun getNasaImage(query: String): Single<List<NasaImage>>
}