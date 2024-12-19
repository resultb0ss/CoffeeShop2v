package com.example.coffeeshop2v.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop2v.Database.SupabaseClient.client
import com.example.coffeeshop2v.Model.ItemsModel
import com.example.coffeeshop2v.Repository.MainRepository
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val repository = MainRepository()

    fun loadFiltered(id: Int): LiveData<MutableList<ItemsModel>> {
        val listData = MutableLiveData<MutableList<ItemsModel>>()
        listData.value = getData(id)
        return listData
    }

    fun getData(id:Int): MutableList<ItemsModel> {

        val dataList = mutableListOf<ItemsModel>()

        viewModelScope.launch {
            val response = client.from("main").select()
//            {
////                filter {
////                    eq("categoryId", id)
////                }
//            }
//            val data = response.decodeList<ItemsModel>()
            Log.d("@@@","DataA${response}")
//            dataList.addAll(data)
        }
        return dataList

    }


}