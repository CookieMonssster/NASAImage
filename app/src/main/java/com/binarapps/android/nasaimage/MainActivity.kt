package com.binarapps.android.nasaimage

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.binarapps.android.nasanetwork.model.NasaImage
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NasaImageAdapterListener {

    private val viewModel = MainViewModel()

    private val nasaAdapter = NasaImageAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel.liveData.observe(this, Observer { nasaAdapter.setList(it) })
        viewModel.fetchImages("")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.search) as MenuItem
        val searchView = searchItem.actionView as SearchView
        searchView.setQueryHint("Search NASA Image")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.fetchImages(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.fetchImages(query)
                return false
            }

        })
        return true
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
