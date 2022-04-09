package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.databinding.FragmentUserBinding


class UserFragment : Fragment() {
    private lateinit var  binding : FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_user,container,false)
        (activity as AppCompatActivity)?.supportActionBar?.hide()
        binding.sign.setOnClickListener {
          view!!.findNavController().navigate(UserFragmentDirections.actionUserFragmentToUserSignUpFragment())
      }
        binding.home.setOnClickListener {
            view!!.findNavController().navigate(UserFragmentDirections.actionUserFragmentToHomeFragment2())
        }

        return binding.root
    }


}