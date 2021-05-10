package com.mynotes.notes.UI.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mynotes.notes.Fruits
import com.mynotes.notes.R
import com.mynotes.notes.adpter.Adpter
import com.mynotes.notes.databinding.ActivityRecyclerViewBinding

class RecyclerView_Activity : AppCompatActivity() {
    private lateinit var dataabing :ActivityRecyclerViewBinding
    val futis = listOf(Fruits("ankur","patel"),Fruits("Google","patel"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataabing = DataBindingUtil.setContentView(this,
            R.layout.activity_recycler_view_
        )
       // setContentView(R.layout.activity_recycler_view_)
        dataabing.recyclerView.setBackgroundColor(resources.getColor(R.color.colorAccent))
        dataabing.recyclerView.layoutManager = LinearLayoutManager(this)
        dataabing.recyclerView.adapter =
            Adpter(futis)
    }
}
