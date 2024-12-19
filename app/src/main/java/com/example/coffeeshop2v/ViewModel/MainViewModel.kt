package com.example.coffeeshop2v.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop2v.Database.SupabaseClient.client
import com.example.coffeeshop2v.Model.ItemsModel
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun loadFiltered(id: Int): LiveData<MutableList<ItemsModel>> {
        val listData = MutableLiveData<MutableList<ItemsModel>>()
        val dataList = mutableListOf<ItemsModel>()

        viewModelScope.launch {
            val response = client.from("main").select(Columns.ALL)
            {
                filter {
                    eq("categoryId", id)
                }
            }
            val data = response.decodeList<ItemsModel>()
            dataList.addAll(data)
            listData.value = dataList
        }

        return listData
    }



}