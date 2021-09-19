package com.example.yana.home14

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.example.yana.home14.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var spinnerIm = ""

    private val arreyColors =
        arrayOf(R.color.blu, R.color.red, R.color.yellow, R.color.green, R.color.purple)
    private val arreyImage =
        arrayOf(R.drawable.ic_1, R.drawable.ic_2, R.drawable.ic_3, R.drawable.ic_4, R.drawable.ic_5)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapterSpinner()
        setupListeners()
        setupListenersSel()
        setupSimpleAdapterSpinner()
    }

    private fun setupListeners() {
        binding.btnSp.setOnClickListener() {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(
                SecondActivity.spinnerImage,
                arreyImage[binding.spImage.selectedItemPosition]
            )
            intent.putExtra(
                SecondActivity.spColor,
                arreyColors[binding.spColor.selectedItemPosition]
            )
            startActivity(intent)
        }
        binding.spColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.colorsLayout.setBackgroundColor(
                    ContextCompat.getColor(this@MainActivity, arreyColors[p2])
                )
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun setupListenersSel() {
        binding.spImage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerIm = p0?.selectedItem.toString()
                binding.spinnerImage.setImageDrawable(
                    ContextCompat.getDrawable(this@MainActivity, arreyImage[p2])
                )
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun setupAdapterSpinner() {
        val array = resources.getStringArray(R.array.color)
        val adapter = SpinnerAdapter(this, R.layout.item_selected_sp, array)
        binding.spColor.adapter = adapter
    }

    private fun setupSimpleAdapterSpinner() {
        val array = resources.getStringArray(R.array.foto)
        val adapter = SpinnerAdapter(this, R.layout.item_selected_sp, array)
        binding.spImage.adapter = adapter
    }
}

//binding.btnSp.setOnClickListener() {
//    val intent = Intent(this, SecondActivity::class.java)
//    startActivity(intent)}


