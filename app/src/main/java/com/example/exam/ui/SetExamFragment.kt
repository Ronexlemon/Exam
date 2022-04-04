package com.example.exam.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.exam.Data.MyData
import com.example.exam.R
import com.example.exam.databinding.FragmentSetExamBinding
import com.example.exam.ui.model.MyViewModel
import com.google.firebase.database.DatabaseException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SetExamFragment : Fragment() {
    private lateinit var binding:FragmentSetExamBinding
    private  lateinit var viewmodel:MyViewModel
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel=ViewModelProvider(this).get(MyViewModel::class.java)
        viewmodel.increment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_set_exam,container,false)
               (activity as AppCompatActivity).supportActionBar?.hide()

        binding.lifecycleOwner=activity
        binding.myView= viewmodel
        binding.submit.setOnClickListener {
            val add1= viewmodel.submit()
           val  add = binding.quiz.text.toString()
            setData(add,add1)
        }


        return binding.root
    }

    private fun setData(add:String,data:MyData) {
       val progress = ProgressDialog(activity)
        progress.setTitle("saving ...")
        progress.show()
       // val data = MyData(add,"Nairobi","ffgsdgsd","gdgdg","ddsgsdsd","A")

        try{
            database= FirebaseDatabase.getInstance("https://online-exam-c73fe-default-rtdb.firebaseio.com/").reference.child("Exam")
            database.child(add.toString()).setValue(data).addOnSuccessListener {
                progress.dismiss()
                Toast.makeText(activity,"Success",Toast.LENGTH_SHORT).show()
                Log.i("Tag","successful")
            }.addOnFailureListener {
                Log.i("Tag","successful")
                progress.dismiss()
                Toast.makeText(activity,"Failed",Toast.LENGTH_SHORT).show()
            }}
        catch (E: DatabaseException){
            Toast.makeText(activity,"Exemption",Toast.LENGTH_SHORT).show()
            Log.i("Tag","exception")
        }
    }


}