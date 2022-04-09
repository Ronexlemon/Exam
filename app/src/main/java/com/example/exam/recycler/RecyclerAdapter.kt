package com.example.exam.recycler

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.Data.MyData
import com.example.exam.R
import com.example.exam.databinding.CustomRecyclerBinding

class RecyclerAdapter(private  var data:List<MyData>):RecyclerView.Adapter<MyViewHolder>() {
    private lateinit var binding:CustomRecyclerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutinflater =LayoutInflater.from(parent.context)
        binding=DataBindingUtil.inflate(layoutinflater, R.layout.custom_recycler,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(data[position])


    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class MyViewHolder( var binding: CustomRecyclerBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(data:MyData){
        binding.question.text=data.question.toString()
        binding.optionA.text=data.optionA.toString()
        binding.optionB.text=data.optionB.toString()
        binding.optionC.text=data.optionC.toString()
        binding.optionD.text=data.optionD.toString()

    }

}