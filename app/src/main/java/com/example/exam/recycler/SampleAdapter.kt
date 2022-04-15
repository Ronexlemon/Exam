package com.example.exam.recycler

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.CustomRecyclerBinding


class SampleAdapter : RecyclerView.Adapter<SampleAdapter.CustomViewHolder>() {
    private lateinit var binding:CustomRecyclerBinding


    inner class CustomViewHolder(binding:CustomRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        val mEditText: EditText = binding.answerEdi

        init {
            mEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun afterTextChanged(editable: Editable) {}
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    if (mEditText.tag != null) {
                        mEditTextValues[mEditText.tag as Int] =
                            charSequence.toString()
                    }
                }
            })
        }
    }

    companion object {
        public var mEditTextValues: MutableList<String> = ArrayList()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutinflater =LayoutInflater.from(parent.context)
        binding= DataBindingUtil.inflate(layoutinflater, com.example.exam.R.layout.custom_recycler,parent,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val viewHolder = holder as CustomViewHolder
        viewHolder.mEditText.tag = position
        viewHolder.mEditText.setText(mEditTextValues[position])
    }

    override fun getItemCount(): Int {
        return mEditTextValues.size
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}
