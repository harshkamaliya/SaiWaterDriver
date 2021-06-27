package com.tejeet.saiwatersuppliers.Ui.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.saiwaterdriver.Data.Model.AllOrder
import com.example.saiwaterdriver.R

class OrdersAdapter(private var dataList:MutableList<AllOrder>, private val itemClickListener: OrderItemClickListener)
    :RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_order,parent,false)
        return   OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {

        holder.apply {

                tvOrderTime.text = dataList[position].ordertime
                tvSocietyName.text = dataList[position].societyName

//                if (!dataList[position].filledby.equals("0")) {
//                    tvOrderAddress.text = dataList[position].filledby
//                }

              val status = dataList[position].orderStatus
            if (status.equals("0")){
                btnAccept.text = "Catch Order"

              //  btnAccept.setBackgroundColor(Color.parseColor("#4BEC00"))

            }else if (status.equals("1")){
                btnAccept.text = "Dispatched"
              //  btnAccept.setBackgroundColor(Color.parseColor("#808080"))
            }else{
                btnAccept.text = "Delivered"
            //    btnAccept.setBackgroundColor(Color.parseColor("#808080"))

            }
            btnAccept.setOnClickListener {

                itemClickListener.onOrderItemClicked(dataList[position])
                if (status.equals("0")){
                    btnAccept.text = "Dispatched"
                   // btnAccept.setBackgroundColor(Color.parseColor("#4BEC00"))

                }else if (status.equals("1")){
                    btnAccept.text = "Delivered"
                   // btnAccept.setBackgroundColor(Color.parseColor("#808080"))
                }

            }
        }
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    fun updateData( newData:MutableList<AllOrder>){
        dataList = newData
        notifyDataSetChanged()
    }


    class OrderViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

         val tvSocietyName = itemView.findViewById<TextView>(R.id.tvSocietyName)
         val tvOrderTime = itemView.findViewById<TextView>(R.id.tvOrderTime)
         val tvOrderAddress = itemView.findViewById<TextView>(R.id.tvOrderAddress)
         val btnAccept = itemView.findViewById<TextView>(R.id.btnAccept)


    }




}