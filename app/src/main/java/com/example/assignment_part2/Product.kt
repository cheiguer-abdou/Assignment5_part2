package com.example.assignment_part2

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val productImage: Int, val productLogo: Int, val productName: String?, val productDescription: String?,
    val productPrice: Double): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(productImage)
        parcel.writeInt(productLogo)
        parcel.writeString(productName)
        parcel.writeString(productDescription)
        parcel.writeDouble(productPrice)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}