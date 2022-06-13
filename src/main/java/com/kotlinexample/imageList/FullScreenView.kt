package com.kotlinexample.imageList

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kotlinexample.listsorting.R
import kotlin.math.max
import kotlin.math.min

class FullScreenView : AppCompatActivity() {
  /*  private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f
    *//*
    private lateinit var imageNews: ImageView
    private var scaleGestureDetector: ScaleGestureDetector? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreenview)

        var imageNews : ImageView = findViewById(R.id.fullscreen)

        val imageId =  intent.getStringExtra("imageId")
        if (imageId != null) {
            Glide.with(this).load(imageId).into(imageNews)

  //          initControls()
        }

/*
        fun initcontrols(){
            if (imageNews == null){
                imageNews = findViewById(R.id.fullscreen);
            }
            if(scaleGestureDetector == null){
                val onPinchListener = ZoomActivity.OnPinchListener(applicationContext, imageNews)

                scaleGestureDetector = ScaleGestureDetector(applicationContext, onPinchListener)
            }
        }
*/


  //      scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

 /*   override fun onTouchEvent(motionEvent: MotionEvent?): Boolean {
        scaleGestureDetector?.onTouchEvent(motionEvent)
        return true
    }*/
/*
    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = max(0.1f, min(scaleFactor, 10.0f))
            imageNews.scaleX = scaleFactor
            imageNews.scaleY = scaleFactor
            return true
        }
    }*/
}