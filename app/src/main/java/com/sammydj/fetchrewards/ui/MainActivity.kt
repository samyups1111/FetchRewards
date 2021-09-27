package com.sammydj.fetchrewards.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.fetchrewards.MainApplication
import com.sammydj.fetchrewards.MainViewModel
import com.sammydj.fetchrewards.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainRecyclerView : RecyclerView
    private lateinit var mainRecyclerViewAdapter : MainRecyclerViewAdapter
    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this,
            MainViewModel.MainViewModelFactory((application as MainApplication).mainRepository)
        ).get(
            MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        loadData()
    }

    private fun initRecyclerView() {
        mainRecyclerView = findViewById(R.id.main_recyclerview)
        mainRecyclerViewAdapter = MainRecyclerViewAdapter()

        mainRecyclerView.apply {
            adapter = mainRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    // Observing LiveData. More useful if the UI interacts with the data (i.e. through a button)
    private fun loadData() {
        viewModel.itemsInDatabase.observe(this, Observer { itemList ->
            mainRecyclerViewAdapter.updateList(itemList)
        })
    }
}