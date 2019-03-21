package com.binarapps.android.nasanetwork.repository

import com.binarapps.android.nasanetwork.model.NasaImage

class NasaRepositoryImpl : NasaRepository {

    override fun getNasaImage(query: String): List<NasaImage> {
        //TODO add implementataion
        return listOf(
            NasaImage(
                "Saturn Apollo Program",
                "The crowning achievement for the Saturn V rocket came when it launched Apollo 11 astronauts, Neil Armstrong, Edwin (Buzz) Aldrin, and Michael Collins, to the Moon in July 1969. In this photograph, astronaut Aldrin takes his first step onto the surface of the Moon.",
                "1969-07-01",
                "images-assets.nasa.gov/image/6900937/6900937~orig.jpg"
            )
        )
    }
}