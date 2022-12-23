package com.example.quicknote.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

@SuppressLint("ParcelCreator")
data class TravelModel(
    val id: Int,
    @DrawableRes
    val drawableRes: Int,
    val title: String,
    val date: String,
    val images: List<Int>?,
    val body: String,
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}