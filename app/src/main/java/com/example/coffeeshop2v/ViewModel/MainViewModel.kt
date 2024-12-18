package com.example.coffeeshop2v.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop2v.Database.SupabaseClient.client
import com.example.coffeeshop2v.Model.ItemsModel
import com.example.coffeeshop2v.Repository.MainRepository
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val repository = MainRepository()

    fun loadFiltered(id: Int): LiveData<MutableList<ItemsModel>> {
        return repository.loadFiltered(id)
    }


}