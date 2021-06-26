package com.example.saiwaterdriver.Data.Model


import com.google.gson.annotations.SerializedName

data class UpdateOrderStatusDTO(
    @SerializedName("message")
    val message: String,
    @SerializedName("requeststatus")
    val requeststatus: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("tid")
    val tid: String
)