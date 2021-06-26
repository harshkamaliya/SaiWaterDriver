package com.tejeet.saiwatercustomer.Viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.saiwaterdriver.Data.Model.AllOrder
import com.example.saiwaterdriver.Data.Model.UpdateOrderStatusDTO
import com.tejeet.saiwatersuppliers.Constant.ResultData
import com.tejeet.saiwatersuppliers.Repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    application: Application
): AndroidViewModel(application) {



    suspend fun updateOrderStatus(
        userId:String,driverName:String,userEmail:String,orderStatus:String,customerId:String,orderId:String
    ): Response<UpdateOrderStatusDTO> {

        val response = CoroutineScope(Dispatchers.IO).async {
            return@async mainRepository.updateOrderStatus(userId,driverName,userEmail,orderStatus,customerId,orderId)

        }
        return response.await()

    }

    fun getAllOrders(userId:String,userEmail:String): LiveData<ResultData<MutableList<AllOrder>?>> {


        return flow {
            emit(ResultData.Loading())
            if (hasInternetConnection()){
                emit(ResultData.Success(mainRepository.getAllOrder(userId,userEmail)))
            }else{
                emit(ResultData.Exception("NO Internet Connection"))
            }

        }.asLiveData(Dispatchers.IO)

    }

    fun hasInternetConnection():Boolean{
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        )as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when{
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false;
        }
    }
}