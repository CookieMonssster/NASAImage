package com.binarapps.android.nasaimage

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.binarapps.android.nasanetwork.model.NasaImage
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NasaImageAdapterListener {

    private val viewModel = MainViewModel()

    private val nasaAdapter = NasaImageAdapter(this)

    private var inputPlanet:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel.liveData.observe(this, Observer { nasaAdapter.setList(it) })
        viewModel.fetchImages(inputPlanet) // Load general data

        subQuerryButton.setOnClickListener {
            inputPlanet = findPlanetText.text.toString()

            if(viewModel.fetchImages(inputPlanet))
            {
                Toast.makeText(this@MainActivity,"Data loaded",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity,"No Data",Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun setupRecyclerView() {
        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = nasaAdapter
        }
    }

    override fun onItemClicked(nasaImage: NasaImage) {
        val nasaImageJson = Gson().toJson(nasaImage)
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("image", nasaImageJson)
        startActivity(intent)
    }

}
