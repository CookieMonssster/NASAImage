package com.binarapps.android.nasanetwork.repository

import com.binarapps.android.nasanetwork.model.NasaImage

interface NasaRepository {

    fun getNasaImage(query: String): List<NasaImage>
}