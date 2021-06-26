package com.tejeet.saiwatersuppliers.Repository


import com.example.saiwaterdriver.Data.Model.AllOrder
import com.example.saiwaterdriver.Data.Model.GetAllOrdersDTO
import com.example.saiwaterdriver.Data.Model.UpdateOrderStatusDTO
import com.tejeet.saiwatercustomer.Network.ApiService
import com.tejeet.saiwatersuppliers.Constant.ConstantsData.API_KEY
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(
   private val apiService: ApiService
){



   suspend fun getAllOrder(userId:String,userEmail:String,): MutableList<AllOrder>{
      return apiService.getAllOrders("Ok",API_KEY,userId,userEmail).body()?.allOrders as MutableList<AllOrder>
   }

   suspend fun updateOrderStatus(userId:String,driverName:String,userEmail:String,orderStatus:String,customerId:String,orderId:String): Response<UpdateOrderStatusDTO>{
      return apiService.updateOrderStatus("OK", API_KEY,userId,driverName,userEmail,orderStatus,customerId,orderId)
   }



}