package com.binarapps.android.nasaimage

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.binarapps.android.nasanetwork.model.NasaImage
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NasaImageAdapterListener {

    override fun onItemClicked(nasaImage: NasaImage) {
        val nasaImageJson = Gson().toJson(nasaImage)
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("image", nasaImageJson)
        startActivity(intent)
    }

    private val viewModel = MainViewModel()

    private val nasaAdapter = NasaImageAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel.liveData.observe(this, Observer { nasaAdapter.setList(it) })
        viewModel.fetchImages()
    }

    private fun setupRecyclerView() {
        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = nasaAdapter
        }
    }
}
