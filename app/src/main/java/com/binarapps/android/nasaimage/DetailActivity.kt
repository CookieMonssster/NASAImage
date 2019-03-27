package com.binarapps.android.nasaimage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.binarapps.android.nasanetwork.model.NasaImage
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val nasaImageJson = intent.getStringExtra("image")
        nasaImageJson?.let {
            val nasaImage = Gson().fromJson(it, NasaImage::class.java)
            setData(nasaImage)
        }
    }

    private fun setData(nasaImage: NasaImage) {
        detailTitle.text = nasaImage.title
        detailDescription.text = nasaImage.description
        Glide.with(this)
            .load(nasaImage.image)
            .centerCrop()
            .into(detailImage)
    }
}