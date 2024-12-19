package com.example.coffeeshop2v.Database

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.serializer.JacksonSerializer
import io.github.jan.supabase.serializer.KotlinXSerializer
import io.github.jan.supabase.storage.Storage

object SupabaseClient {

    val client = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASEURL,
        supabaseKey = BuildConfig.SUPABASEKEY
    ) {
        defaultSerializer = JacksonSerializer()
        install(Storage)
        install(Postgrest)
        install(Realtime)
    }
}