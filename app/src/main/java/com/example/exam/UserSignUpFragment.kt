package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.databinding.FragmentUserSignUpBinding
import com.example.exam.ui.SignupFragmentDirections


class UserSignUpFragment : Fragment() {

private lateinit var  binding: FragmentUserSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_user_sign_up,container,false)
       binding.login.setOnClickListener {
           view!!.findNavController().navigate(UserSignUpFragmentDirections.actionUserSignUpFragmentToUserFragment())
       }
        return binding.root
    }


}