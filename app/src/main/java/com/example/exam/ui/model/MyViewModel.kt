package com.example.exam.ui.model

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exam.Data.MyData
import com.example.exam.recycler.RecyclerAdapter
import com.example.exam.recycler.SampleAdapter
import com.example.exam.ui.Answer
import java.util.ArrayList

class MyViewModel: ViewModel(),Observable{
val samp = SampleAdapter

var count=1
    @Bindable
    val question = MutableLiveData<String>()
    @Bindable
    val optionA = MutableLiveData<String>()
    @Bindable
    val optionB = MutableLiveData<String>()
    @Bindable
    val optionC = MutableLiveData<String>()
    @Bindable
    val optionD = MutableLiveData<String>()
    @Bindable
    val answer = MutableLiveData<String>()
    @Bindable
    val questionNumber= MutableLiveData<String>()
    @Bindable
    val answerEdit =  MutableLiveData<String>()
    val arrayEdit = listOf<Answer>()
    var arraysAll: MutableList<Answer> = ArrayList()
    var arrt =RecyclerAdapter.mEditTextValues

    fun submitEdit():MutableList<Answer>{
        try{
            Answer("A")
            val ans = answerEdit.value!!

            val data = Answer(ans)

            arraysAll.add(data)
            return arraysAll
        }
        catch (E:NullPointerException){
            Log.i("TAAG",answerEdit.value.toString())
        }


        return arraysAll



    }

    fun submit():MyData{
        val answer= answer.value!!
        val question = question.value!!
        val optionA =optionA.value!!
        val optionB =optionB.value!!
        val optionC =optionC.value!!
        val optionD =optionD.value!!

        val add =MyData(question, optionA, optionB, optionC, optionD, answer)
  Log.i("Tag",add.toString())
        clear()
       increment()
        return  add



    }
    fun increment(){
        questionNumber.value = count.toString()
        count+=1
    }
    fun clear(){
        optionA.value=""
        optionB.value=""
        optionC.value=""
        optionD.value=""
        answer.value=""
        question.value=""


    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}