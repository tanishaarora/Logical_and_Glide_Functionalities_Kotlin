package com.kotlinexample.imageList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexample.listsorting.R
import com.bumptech.glide.Glide

class ImageListAdapter( private val context: Context, private val imgUrls: ArrayList<String>) :
    RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemCLick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.ViewHolder {
        val image = LayoutInflater.from(parent.context).inflate(R.layout.activity_image_design, parent, false)

        return ViewHolder(image, mListener)
    }

    override fun onBindViewHolder(holder: ImageListAdapter.ViewHolder, position: Int) {

        Glide.with(context).load(imgUrls[position]).override(800, 800).into(holder.imageView1)

    }

    override fun getItemCount(): Int {
        return imgUrls.size
    }
    class ViewHolder(imageAdapter: View,  listener: ImageListAdapter.onItemClickListener):RecyclerView.ViewHolder(imageAdapter) {
        val imageView1: (ImageView) = itemView.findViewById(R.id.image)

        init {
            itemView.setOnClickListener {
                listener.onItemCLick(absoluteAdapterPosition)
            }
        }
    }
}