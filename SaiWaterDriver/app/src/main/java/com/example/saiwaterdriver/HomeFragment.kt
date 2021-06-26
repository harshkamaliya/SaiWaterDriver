package com.example.saiwaterdriver

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saiwaterdriver.Data.Model.AllOrder
import com.example.saiwaterdriver.databinding.FragmentHomeBinding
import com.tejeet.saiwatercustomer.Viewmodel.MainViewModel
import com.tejeet.saiwatersuppliers.Constant.ResultData
import com.tejeet.saiwatersuppliers.Ui.Adapters.OrderItemClickListener
import com.tejeet.saiwatersuppliers.Ui.Adapters.OrdersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(),OrderItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var ordersAdapter: OrdersAdapter
    var orderList:MutableList<AllOrder> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setUpRecyclerview()

        mainViewModel.getAllOrders("1","tejeetm@gmail.com")
            .observe(viewLifecycleOwner, Observer {response->

                when(response){
                    is ResultData.Loading -> {

                        binding.recyclerviewOrder.visibility = View.INVISIBLE
                        binding.lottieLoading.visibility = View.VISIBLE

                    }
                    is ResultData.Success -> {
                        binding.recyclerviewOrder.visibility = View.VISIBLE
                        binding.lottieLoading.visibility = View.INVISIBLE
                        response.data?.let {
                            ordersAdapter.updateData(it)
                        }
                    }
                    is ResultData.Exception ->{

                    }
                }
            })

        return binding.root
    }

    private fun setUpRecyclerview() {

        ordersAdapter = OrdersAdapter(orderList,this)
        binding.recyclerviewOrder.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewOrder.adapter = ordersAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOrderItemClicked(customer: AllOrder) {

        CoroutineScope(Dispatchers.Main).launch {
            if (customer.orderStatus.equals("0")) {
               val response =  mainViewModel.updateOrderStatus(
                    "1", "PQRST",
                    "manish@gmail.com", "1",customer.uid,customer.oid)
                val ss = response

            }else if (customer.orderStatus.equals("1")) {
               val response = mainViewModel.updateOrderStatus(
                    "1", "PQRST",
                    "manish@gmail.com", "2",customer.uid,customer.oid)
                val ss = response
            }
        }


    }

}