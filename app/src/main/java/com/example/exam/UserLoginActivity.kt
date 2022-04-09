package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam.databinding.ActivityUserLoginBinding

class UserLoginActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityUserLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}