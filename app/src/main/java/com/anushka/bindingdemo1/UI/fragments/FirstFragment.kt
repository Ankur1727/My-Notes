package com.mynotes.notes.UI.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mynotes.notes.R
import com.mynotes.notes.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {
    private  lateinit var databing :FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_first, container, false)
        databing = DataBindingUtil.inflate(inflater,
            R.layout.fragment_first,container,false)

        databing.btnNxt.setOnClickListener {
            if (!TextUtils.isEmpty(databing.inputName.text.toString())){
                var bundle:Bundle = bundleOf("name_input" to databing.inputName.text.toString())
                it.findNavController().navigate(R.id.action_firstFragment_to_seondFragmnet,bundle)

            }else{
                Toast.makeText(context,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }
        }
        return databing.root
    }

}
