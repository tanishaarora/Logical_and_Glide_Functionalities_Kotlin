package com.kotlinexample.imageList

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ScaleGestureDetector
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint

import android.graphics.drawable.BitmapDrawable
import java.util.zip.DeflaterOutputStream


class ZoomActivity : ScaleGestureDetector.SimpleOnScaleGestureListener() {

    class OnPinchListener(applicationContext: Context?, imageView: Any) :
        ScaleGestureDetector.OnScaleGestureListener {

        private val TAG_PINCH_LISTENER = "PINCH_LISTENER"
        private var srcImageView: ImageView? = null
        private var context: Context? = null

        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            if (detector != null) {
                val scaleFactor = detector.scaleFactor
                if (srcImageView != null) {
                    // Scale the image with pinch zoom value.
                    scaleImage(scaleFactor, scaleFactor)
                } else {
                    if (context != null) {
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e(TAG_PINCH_LISTENER, "Both context and srcImageView is null.")
                    }
                }
            } else {
                Log.e(TAG_PINCH_LISTENER, "Pinch listener onScale detector parameter is null.")
            }
            return true
        }

        private fun scaleImage(scaleFactor: Float, scaleFactor1: Float) {
            var srcImageView: ImageView? = null
            val srcBitmapDrawable = srcImageView!!.drawable as BitmapDrawable
            val srcBitmap = srcBitmapDrawable.bitmap
            val srcImageWith = srcBitmap.width
            val srcImageHeight = srcBitmap.height
            val srcImageConfig: Bitmap.Config = srcBitmap.config
            val scaleBitmap = Bitmap.createBitmap(
                (srcImageWith * scaleFactor) as Int,
                (srcImageHeight * scaleFactor1) as Int,
                srcImageConfig
            )
            val scaleCanvas = Canvas(scaleBitmap)
            val scaleMatrix = Matrix()
            scaleMatrix.setScale(scaleFactor, scaleFactor1)

            val paint = Paint()
            scaleCanvas.drawBitmap(srcBitmap, scaleMatrix, paint)
            srcImageView!!.setImageBitmap(scaleBitmap)
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return false
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
        }

    }
}
