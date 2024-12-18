package com.example.coffeeshop2v.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeeshop2v.Database.SupabaseClient.client
import com.example.coffeeshop2v.Model.ItemsModel
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainRepository {


    fun loadFiltered(id: Int): LiveData<MutableList<ItemsModel>> {

        val listData = MutableLiveData<MutableList<ItemsModel>>()
        listData.value = getData()
        Log.d("@@@","MainRepository listdata filtered${listData}")
        return listData
    }

    fun getData(): MutableList<ItemsModel> {
        val dataList = mutableListOf<ItemsModel>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = client.postgrest["main"].select()
            val data = response.decodeList<ItemsModel>()
            dataList.addAll(data)
            Log.d("@@@","MainRepository listdata getDATA${dataList}")
            print("")
        }
        return dataList

    }
}