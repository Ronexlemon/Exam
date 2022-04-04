package com.example.exam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.R
import com.example.exam.databinding.FragmentLoginBinding
import com.example.exam.databinding.FragmentSignupBinding

//
class SignupFragment : Fragment() {
    private lateinit var  binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_signup,container,false)
      binding.apply {
          login.setOnClickListener {
              view?.findNavController()?.navigate(SignupFragmentDirections.actionSignupFragmentToLoginFragment())
          }
          sign.setOnClickListener {
              view?.findNavController()?.navigate(SignupFragmentDirections.actionSignupFragmentToSetExamFragment())
          }
      }
        return binding.root
    }


}