package com.example.exam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity

import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.R
import com.example.exam.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        (activity as AppCompatActivity).supportActionBar?.hide()
        getBottom()
        binding.apply {
            admin.setOnClickListener {
                Toast.makeText(activity,"admin", LENGTH_SHORT).show()
                view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
            }
            user.setOnClickListener {
                Toast.makeText(activity,"candidate", LENGTH_SHORT).show()
            }
            setting.setOnClickListener {
                Toast.makeText(activity,"setting", LENGTH_SHORT).show()
            }
            exam.setOnClickListener {
                Toast.makeText(activity,"exam", LENGTH_SHORT).show()
            }
        }



        return binding.root
    }

    private fun getBottom() {
        binding.bottomNav.setOnItemReselectedListener {
            when(it.itemId){
                R.id.home ->{Toast.makeText(activity,"home", LENGTH_SHORT).show()}
                R.id.search ->{Toast.makeText(activity,"search", LENGTH_SHORT).show()}
                R.id.grade ->{Toast.makeText(activity,"grade", LENGTH_SHORT).show()}
                R.id.mail ->{Toast.makeText(activity,"mail", LENGTH_SHORT).show()}
            }

        }
    }


}