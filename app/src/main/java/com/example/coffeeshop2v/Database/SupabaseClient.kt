package com.example.coffeeshop2v.Database

import com.example.coffeeshop2v.Database.BuildConfig
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage

object SupabaseClient {

    val client = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASEURL,
        supabaseKey = BuildConfig.SUPABASEKEY
    ){
        install(Auth)
        install(Storage)
        install(Postgrest)
        install(Realtime)
    }
}