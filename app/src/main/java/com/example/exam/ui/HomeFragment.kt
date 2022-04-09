package com.example.exam.ui


import android.content.Intent
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
import com.example.exam.ExamActivity
import com.example.exam.R
import com.example.exam.UserLoginActivity
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
                val intent = Intent(activity,UserLoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(activity,"candidate", LENGTH_SHORT).show()
            }
            setting.setOnClickListener {
                val intent = Intent(activity,SettingActivity::class.java)
                startActivity(intent)
                Toast.makeText(activity,"setting", LENGTH_SHORT).show()
            }
            exam.setOnClickListener {
                val intent: Intent = Intent(activity, ExamActivity::class.java)

                startActivity(intent)
                Toast.makeText(activity,"exam", LENGTH_SHORT).show()
            }
        }



        return binding.root
    }

    private fun getBottom() {
        binding.bottomNav.setOnItemReselectedListener {
            when(it.itemId){
                R.id.home ->{Toast.makeText(activity,"home", LENGTH_SHORT).show()}
                R.id.search ->{
                    val intent = Intent(activity,SearchActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(activity,"search", LENGTH_SHORT).show()}
                R.id.grade ->{
                    val intent = Intent(activity,Gradectivity::class.java)
                    startActivity(intent)
                    Toast.makeText(activity,"grade", LENGTH_SHORT).show()}
                R.id.mail ->{Toast.makeText(activity,"mail", LENGTH_SHORT).show()}
            }

        }
    }


}