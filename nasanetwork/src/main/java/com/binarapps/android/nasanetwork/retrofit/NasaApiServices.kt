package com.binarapps.android.nasanetwork.retrofit

import com.binarapps.android.nasanetwork.model.NasaImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaApiServices {

    @GET("search")
    fun search(
        @Query("q") query: String,
        @Query("media_type") mediaType: String
    ): Single<NasaImageResponse>

}