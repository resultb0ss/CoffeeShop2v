package com.example.coffeeshop2v.Model

import android.os.Parcel
import android.os.Parcelable


data class ItemsModel(
    var title: String = "",
    var description: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var extra: String = "",
    var categoryId: String = "",
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),

        )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(title)
        p0.writeString(description)
        p0.writeStringList(picUrl)
        p0.writeDouble(price)
        p0.writeString(extra)
        p0.writeString(categoryId)
    }

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(p0: Parcel): ItemsModel? {
            return ItemsModel(p0)
        }

        override fun newArray(p0: Int): Array<out ItemsModel?>? {
            return arrayOfNulls(p0)
        }

    }


}