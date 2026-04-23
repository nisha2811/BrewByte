package com.example.brewbyte.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.brewbyte.ViewModel.MainViewModel
import com.example.brewbyte.adapter.ItemsAdapter
import com.example.brewbyte.databinding.ActivityItemListBinding

class ItemListActivity : AppCompatActivity()
{
    lateinit var binding: ActivityItemListBinding
    private val viewModel = MainViewModel()
    private var id: String = ""
    private var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundles()
        initList()
    }

    private fun getBundles()
    {
        id = intent.getStringExtra("id")!!
        title = intent.getStringExtra("title")!!

        binding.categoryTxt.text = title
        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun initList(){
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadItems(id).observe(this@ItemListActivity, Observer{
                listView.layoutManager =
                    GridLayoutManager(this@ItemListActivity, 2)
                listView.adapter = ItemsAdapter(it)
                progressBar.visibility = View.GONE
            })
            backBtn.setOnClickListener { finish() }
        }
    }
}