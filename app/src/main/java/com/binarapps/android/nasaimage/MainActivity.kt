package com.binarapps.android.nasaimage

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    private val nasaAdapter = NasaImageAdapter()

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
