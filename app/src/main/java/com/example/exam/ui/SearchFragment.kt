package com.example.exam.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.exam.Data.MyData
import com.example.exam.R
import com.example.exam.databinding.FragmentSearchBinding
import com.google.firebase.database.*

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var  database : DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)
        binding.search.setOnClickListener {
            val code = binding.searchText.text.toString()
            getResult(code)
        }
        return binding.root
    }

    private fun getResult(code:String) {
        val progress = ProgressDialog(activity)
        progress.setTitle("Searching ...")
        progress.show()
        database = FirebaseDatabase.getInstance().getReference("Exam")
      database.child(code).addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){


                           val quiz = snapshot.child("question").value
                           val optionA = snapshot.child("optionA").value
                           val optionB = snapshot.child("optionB").value
                           val optionC = snapshot.child("optionC").value
                           val optionD = snapshot.child("optionD").value
                           binding.apply {
                               optiona.text=optionA.toString()
                               optionb.text=optionB.toString()
                               optionc.text=optionC.toString()
                               optiond.text=optionD.toString()
                               quest.text=quiz.toString()
                           }
                    progress.dismiss()



                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(activity,"Error try some other time",Toast.LENGTH_SHORT).show()
            }

        })
    }


}