package com.example.exam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.R
import com.example.exam.databinding.FragmentDeleteBinding

class DeleteFragment : Fragment() {
    private lateinit var binding:FragmentDeleteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_delete,container,false)
      binding.apply {
          home.setOnClickListener {
              view?.findNavController()?.navigate(DeleteFragmentDirections.actionDeleteFragmentToHomeFragment3())
          }
      }
        return binding.root
    }


}