package com.example.coffeeshop2v.Model

import java.io.Serializable

data class ItemsModel(
    var id: Int,
    var title: String,
    var description: String,
    var picUrl: String,
    var price: Double,
    var extra: String,
    var categoryId: String,
): Serializable{

}