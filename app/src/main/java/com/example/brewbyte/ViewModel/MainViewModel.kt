package com.example.brewbyte.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.brewbyte.domain.BannerModel
import com.example.brewbyte.domain.CategoryModel
import com.example.brewbyte.domain.ItemsModel
import com.example.brewbyte.repository.MainRepository

class MainViewModel : ViewModel()
{
    private val repository = MainRepository()

    fun loadCategory() : LiveData<MutableList<CategoryModel>>
    {
        return repository.loadCategory()
    }

    fun loadBanner() : LiveData<MutableList<BannerModel>>
    {
        return repository.loadBanner()
    }

    fun loadPopular() : LiveData<MutableList<ItemsModel>>
    {
        return repository.loadPopular()
    }

    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>>
    {
        return repository.loadItemCategory(categoryId)
    }
}