package com.mynotes.notes.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mynotes.notes.Fruits
import com.mynotes.notes.R
import kotlinx.android.synthetic.main.adpter_layout.view.*

class Adpter(var futis: List<Fruits>) :RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.adpter_layout,parent,false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return futis.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val f = futis.get(position)
        holder.view.txt_adpter.text = f.name +" "+f.surname
    }

}
class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){

}