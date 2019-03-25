package com.binarapps.android.nasanetwork.repository

import com.binarapps.android.nasanetwork.model.NasaImage
import com.binarapps.android.nasanetwork.retrofit.NasaApiServices
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NasaRepository : NasaRepositoryInterface {

    private var api = initializeRetrofit()

    override fun getNasaImage(query: String, mediaType: String): Single<List<NasaImage>> {
        return api.search(query, mediaType)
            .map { response ->
                response.collection.items.map { NasaImage(it) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun initializeRetrofit(): NasaApiServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()

            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NasaApiServices::class.java)
    }

    companion object {
        private const val BASE_URL = "https://images-api.nasa.gov"
    }
}