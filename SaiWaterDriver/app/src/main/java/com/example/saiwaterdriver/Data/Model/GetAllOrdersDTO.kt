package com.example.saiwaterdriver.Data.Model


import com.google.gson.annotations.SerializedName

data class GetAllOrdersDTO(
    @SerializedName("AllOrders")
    val allOrders: List<AllOrder>,
    @SerializedName("nooforders")
    val nooforders: Int,
    @SerializedName("requeststatus")
    val requeststatus: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("tid")
    val tid: String
)