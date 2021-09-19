package com.example.yana.home14

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Picture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.drawToBitmap
import com.example.yana.home14.databinding.ActivityMainBinding
import com.example.yana.home14.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvText.text = intent.getStringExtra(SPINNER)

        val image = intent.getIntExtra(spinnerImage, 0)
        binding.im.setImageDrawable(
            ContextCompat.getDrawable(this, image)
        )

        val color = intent.getIntExtra(spColor, 0)
        binding.bag.setBackgroundColor(
            ContextCompat.getColor(this, color)
        )
    }

    companion object {
        const val spColor = "SPCOLOR"
        const val SPINNER = "SPINNER"
        const val spinnerImage = "SPINNERIMAGE"

    }
}

