package com.binarapps.android.nasaimage

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.inputmethod.InputMethodManager
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()
    val listAdapter : NasaImageAdapter = NasaImageAdapter()
    lateinit var inputMethodManager : InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = listAdapter
        listAdapter.setContext(this@MainActivity)
        viewModel.liveData.observe(this@MainActivity, Observer{ it ->
            it?.let(listAdapter::setData)
        })
        fetchImage()

        inputMethodManager = getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager

        search_button.setOnClickListener {
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            Common.query = search_query.text.toString()
            fetchImage()
            recyclerView.smoothScrollToPosition(0)
        }
    }

    private fun fetchImage(){
        viewModel.fetchImages(Common.query)
    }

    private fun setupRecyclerView() {
        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter  = listAdapter

        }
    }

    override fun onBackPressed() {
        if(Common.query != ""){
            Common.query = ""
            search_query.text.clear()
            fetchImage()
        } else {
            super.onBackPressed()
        }
    }
}
