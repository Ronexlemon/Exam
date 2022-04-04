package com.example.exam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.R
import com.example.exam.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var  binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        binding.apply {
            home.setOnClickListener{
                Toast.makeText(activity,"home", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            }
            sign.setOnClickListener{
                Toast.makeText(activity,"home", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
            }
            login.setOnClickListener {
                view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToSetExamFragment())
            }
        }
        return binding.root
    }


}