package com.mynotes.notes.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mynotes.notes.R
import com.mynotes.notes.databinding.ItmRooomLayoutBinding
import com.mynotes.notes.db.Subcriber_Data
import com.mynotes.notes.db.Subscriber_Database

class Recycelerview_room_Adpter (private val subscriberData: List<Subcriber_Data>):RecyclerView.Adapter<MyViwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViwHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        val binding :ItmRooomLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.itm_rooom_layout,parent,false)
        return MyViwHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscriberData.size
    }

    override fun onBindViewHolder(holder: MyViwHolder, position: Int) {
        holder.bind(subscriberData[position])
    }
}
class  MyViwHolder(val binding :ItmRooomLayoutBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(subscriberData: Subcriber_Data){
        binding.txtName.text = subscriberData.name
        binding.txtEmail.text = subscriberData.email
    }

}