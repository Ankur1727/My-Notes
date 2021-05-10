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
import com.mynotes.notes.databinding.FragmentSeondFragmnetBinding

/**
 * A simple [Fragment] subclass.
 */
class SeondFragmnet : Fragment() {
    private lateinit var databing :FragmentSeondFragmnetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
   //     return inflater.inflate(R.layout.fragment_seond_fragmnet, container, false)
        databing = DataBindingUtil.inflate(inflater,
            R.layout.fragment_seond_fragmnet,container,false)

        var input :String? =  requireArguments().getString("name_input")
        databing.btnSubmit.setOnClickListener {
            if (!TextUtils.isEmpty(databing.inputEmail.text.toString())){
                var bundle:Bundle = bundleOf("input_email" to databing.inputEmail.text.toString(),
                    "input_name" to input.toString())
                it.findNavController().navigate(R.id.action_seondFragmnet_to_third_Fragment,bundle)
            }else{
                Toast.makeText(context,"Please Enter Your Email Id",Toast.LENGTH_LONG).show()
            }
        }


       // databing.textView.text = input

        return databing.root
    }

}
