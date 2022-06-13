package com.kotlinexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.kotlinexample.displayedimages.ImageActivity
import com.kotlinexample.imageList.ImageListActivity
import com.kotlinexample.listsorting.Details
import com.kotlinexample.listsorting.R
import com.kotlinexample.spinners.DropDownActivity
import com.kotlinexample.viewpager.ViewPagerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_recyclerview = findViewById<Button>(R.id.recyclerview)
        val btn_spinner = findViewById<Button>(R.id.spinner_main)
        val btn_images = findViewById<Button>(R.id.images_glide)
        val btn_viewpager = findViewById<Button>(R.id.images_viewpager)
        val btn_displayedimages = findViewById<Button>(R.id.images_displayed)

        btn_recyclerview.setOnClickListener{
            intent = Intent(this, Details::class.java)
            startActivity(intent)
        }

        btn_spinner.setOnClickListener{
            intent = Intent(this, DropDownActivity::class.java)
            startActivity(intent)
        }

        btn_images.setOnClickListener{
            intent = Intent(this, ImageListActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager.setOnClickListener {
            intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }

        btn_displayedimages.setOnClickListener {
            intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }

    }
}