package com.kotlinexample.displayedimages

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlinexample.listsorting.R
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.kotlinexample.listsorting.DetailsView
import java.util.ArrayList

class ImageActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_design)

        loadImage()
    }

    private fun loadImage(){

        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
        var imageView : (ImageView) = findViewById(R.id.image)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            {response ->
                val url = response.getString("url")
                Glide.with(this@ImageActivity).load(url).into(imageView)
            },
            Response.ErrorListener {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            })
        queue.add(jsonObjectRequest)
    }

}