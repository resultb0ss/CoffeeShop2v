package com.example.coffeeshop2v.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeeshop2v.Database.SupabaseClient.client
import com.example.coffeeshop2v.Model.ItemsModel
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainRepository {


    fun loadFiltered(id: Int): LiveData<MutableList<ItemsModel>> {

        val listData = MutableLiveData<MutableList<ItemsModel>>()
        return listData

    }


}