package com.binarapps.android.nasanetwork.model

data class NasaImage(
    val nasaItem: Item
) {
    val title: String = nasaItem.data[0].title
    val description: String = nasaItem.data[0].description
    val date: String = nasaItem.data[0].date_created
    val image: String = nasaItem.links[0].href
}