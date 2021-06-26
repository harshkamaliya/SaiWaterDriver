package com.tejeet.saiwatercustomer.Network

import com.example.saiwaterdriver.Data.Model.GetAllOrdersDTO
import com.example.saiwaterdriver.Data.Model.UpdateOrderStatusDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {



    @GET("api/appAdmin.php?")
    suspend fun getAllOrders(
        @Query("getAllOrders") getallOrders : String,
        @Query("trustedAppKey") trustedAppKey:String,
        @Query("userid") societyName : String,
        @Query("useremail") customerName: String
    ): Response<GetAllOrdersDTO>

    @GET("api/appDriver.php?")
    suspend fun updateOrderStatus(
        @Query("updateOrderStatus") updateOrderStatus : String,
        @Query("trustedAppKey") trustedAppKey:String,
        @Query("userid") societyName : String,
        @Query("driverName") driverName:String,
        @Query("useremail") useremail: String,
        @Query("orderStatus") orderStatus: String,
        @Query("customerID") customerID: String,
        @Query("orderID") orderID: String
    ): Response<UpdateOrderStatusDTO>


}