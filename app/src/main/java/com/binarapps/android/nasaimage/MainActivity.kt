package com.binarapps.android.nasaimage

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.binarapps.android.nasanetwork.model.NasaImage
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NasaImageAdapterListener {

    private val viewModel = MainViewModel()

    private val nasaAdapter = NasaImageAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSearchBox()
        setupRecyclerView()
        viewModel.liveData.observe(this, Observer { nasaAdapter.setList(it) })
        viewModel.fetchImages()
    }

    private fun setupSearchBox() {
        search_box.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let { sequence ->
                    Log.i("MainActivity", "onTextChanged(): Input is ${s.toString()}")
                    viewModel.fetchImages(sequence.toString())
                }
            }

        })
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
