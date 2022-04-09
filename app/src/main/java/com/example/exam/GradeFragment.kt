package com.example.exam

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.exam.databinding.FragmentGradeBinding


class GradeFragment : Fragment() {
    private lateinit var  binding:FragmentGradeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_grade,container,false)

        (activity as AppCompatActivity).supportActionBar?.hide()
        return binding.root
    }


}