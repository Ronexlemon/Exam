package com.example.exam

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam.Data.MyData
import com.example.exam.databinding.ActivityExamBinding
import com.example.exam.recycler.RecyclerAdapter
import com.google.firebase.database.*
import com.google.firestore.v1.Value

class ExamActivity : AppCompatActivity() {
    private lateinit var binding:ActivityExamBinding
    private lateinit var database:DatabaseReference
    private var  arraylist = arrayListOf<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_exam)
        initBinding()
        //getData()
        supportActionBar?.hide()
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
                      //  val c = data?.answer?.let { values.child(it) }
   // Toast.makeText(this@ExamActivity,c.toString(),Toast.LENGTH_SHORT).show()
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
