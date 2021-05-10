package com.mynotes.notes.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mynotes.notes.R
import com.mynotes.notes.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass.
 */
class Third_Fragment : Fragment() {
    private lateinit var databing:FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_third_, container, false)
        databing = DataBindingUtil.inflate(inflater,
            R.layout.fragment_third_,container,false)

        var input :String? = requireArguments().getString("input_name")
        var input_email :String? = requireArguments().getString("input_email")
        databing.txtRegistered.text = input.toString()+input_email.toString()

        return databing.root
    }

}
