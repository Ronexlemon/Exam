package com.example.exam

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam.Data.MyData
import com.example.exam.databinding.ActivityExamBinding
import com.example.exam.recycler.RecyclerAdapter
import com.example.exam.ui.model.MyViewModel
import com.google.firebase.database.*

class ExamActivity : AppCompatActivity() {
    private lateinit var binding:ActivityExamBinding
    private lateinit var database:DatabaseReference
    private lateinit var  viewmodel:MyViewModel
    private var  arraylist = arrayListOf<MyData>()
   // private var myViewArray = ArrayList<Answer>()
    private  var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_exam)
        initBinding()
        //getData()
        supportActionBar?.hide()
        viewmodel=ViewModelProvider(this).get(MyViewModel::class.java)
        binding.lifecycleOwner=this

       binding.confirm.setOnClickListener {
           getAnswer()
           count = 0

       }

        binding.sub.setOnClickListener {

            viewmodel.submitEdit()
            binding.confirm.visibility= View.VISIBLE

            //viewmodel.submitEdit()

        }
    }

    private fun getAnswer() {
        val progress=ProgressDialog(this)
        progress.setTitle("getting...")
        progress.show()
        database=FirebaseDatabase.getInstance().getReference("Exam")
        database.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(ans: DataSnapshot) {
                if(ans.exists()){
                    progress.dismiss()
                    for(values in ans.children){

                        val c = values.child("answer").value.toString().uppercase()
                        Log.i("TAAAG",viewmodel.arraysAll.toString())
                        Toast.makeText(this@ExamActivity,viewmodel.arraysAll.toString(),Toast.LENGTH_SHORT).show()
                        when (c) {
                            "A" -> {
                                count +=1
                            }
                            "B" -> {
                                count +=1
                            }
                            "C" -> {
                                count +=1
                            }
                            "D" -> {
                                count +=1
                            }
                        }


                        //Toast.makeText(this@ExamActivity,c,Toast.LENGTH_SHORT).show()
                    }
                    Toast.makeText(this@ExamActivity,count.toString(),Toast.LENGTH_SHORT).show()
                }

                }


            override fun onCancelled(answer: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun getData() {
        val progress=ProgressDialog(this)
        progress.setTitle("Loading...")
        progress.show()
        database=FirebaseDatabase.getInstance().getReference("Exam")
        database.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    progress.dismiss()

                    Toast.makeText(this@ExamActivity,"Found database",Toast.LENGTH_SHORT).show()
                    for(values in snapshot.children){
                        val data = values.getValue(MyData::class.java)
                            arraylist.add(data!!)
                    }
                    binding.recycler.adapter=RecyclerAdapter(arraylist)
                }
            }

            override fun onCancelled(snapshot: DatabaseError) {
                progress.dismiss()
                Toast.makeText(this@ExamActivity,"Canceled",Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun initBinding() {
        binding.recycler.layoutManager=LinearLayoutManager(this)
        binding.recycler.hasFixedSize()
    getData()
    }

    }
