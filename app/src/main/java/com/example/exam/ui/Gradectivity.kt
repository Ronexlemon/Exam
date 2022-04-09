package com.example.exam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam.R
import com.example.exam.databinding.ActivityGradeBinding

class Gradectivity : AppCompatActivity() {
    private lateinit var  binding:ActivityGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}