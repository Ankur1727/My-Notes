package com.mynotes.notes.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mynotes.notes.R
import com.mynotes.notes.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home,container,false)
        binding.button.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_firstFragment2)
        }
        return  binding.root
    }
//    if (!TextUtils.isEmpty(binding.editText.text.toString())){
//        val bundle:Bundle = bundleOf("user_input" to binding.editText.text.toString())
//        it.findNavController().navigate(R.id.action_homeFragment_to_seondFragmnet,bundle)
//
//    }else{
//        Toast.makeText(context,"Please Enter a Name",Toast.LENGTH_LONG).show()
//    }

}
