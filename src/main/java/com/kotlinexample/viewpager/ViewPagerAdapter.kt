package com.kotlinexample.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.kotlinexample.listsorting.R
import android.widget.ImageView


class ViewPagerAdapter(var context: Context, var images: List<Int>): PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view.equals(obj)
    }

    override fun getCount(): Int {
       return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val itemView: View? = layoutInflater.inflate(R.layout.activity_viewpager_design, container, false)
        val imageView: ImageView = itemView?.findViewById<View>(R.id.viewpager_image) as ImageView
        imageView.setImageResource(images[position])
        container.addView(itemView, 0)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}