package com.example.saiwaterdriver.Data.Model


import com.google.gson.annotations.SerializedName

data class AllOrder(
    @SerializedName("customerName")
    val customerName: String,
    @SerializedName("filledby")
    val filledby: String,
    @SerializedName("filltime")
    val filltime: String,
    @SerializedName("oid")
    val oid: String,
    @SerializedName("orderStatus")
    val orderStatus: String,
    @SerializedName("orderdispatchtime")
    val orderdispatchtime: String,
    @SerializedName("ordertime")
    val ordertime: String,
    @SerializedName("societyName")
    val societyName: String,
    @SerializedName("uid")
    val uid: String
)