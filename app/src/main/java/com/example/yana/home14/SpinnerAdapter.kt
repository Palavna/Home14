package com.example.yana.home14

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.yana.home14.databinding.ItemNotSelectedSpBinding
import com.example.yana.home14.databinding.ItemSelectedSpBinding

class SpinnerAdapter(context: Context, resId: Int, private val array: Array<String>) :
    ArrayAdapter<String>(context, resId, array) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            ItemSelectedSpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.tvSpin.text = array[position]
        return binding.root
    }


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            ItemNotSelectedSpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.tvNotSpin.text = array[position]
        return binding.root
    }
}




