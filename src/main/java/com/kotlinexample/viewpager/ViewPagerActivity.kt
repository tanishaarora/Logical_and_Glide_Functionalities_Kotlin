package com.kotlinexample.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import java.util.*
import com.google.android.material.tabs.TabLayout
import com.kotlinexample.listsorting.R

class ViewPagerActivity : AppCompatActivity() {

    var mViewPagerAdapter: ViewPagerAdapter? = null
 /*   private var currentPage = 0
    private val NUM_PAGES = 0*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        val mViewPager = findViewById<ViewPager>(R.id.viewpager)
/*        var dotsIndicator : CircleIndicator = findViewById<CircleIndicator>(R.id.indicator)
        dotsIndicator.setViewPager(mViewPager)*/

        val images: List<Int> = listOf(
            R.drawable.view,
            R.drawable.viewpager,
            R.drawable.view2,
            R.drawable.viewpager2,
            R.drawable.viewpager3
        )

        mViewPagerAdapter = ViewPagerAdapter(this@ViewPagerActivity, images)
        mViewPager!!.adapter = mViewPagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabDots).setupWithViewPager(mViewPager)

    }
}

        /*  mViewPager!!.setOnPageChangeListener(object  : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ){

            }

            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrollStateChanged(state: Int) {
                Toast.makeText(getApplicationContext(), "context changed", Toast.LENGTH_SHORT).show()

                if (state === ViewPager.SCROLL_STATE_IDLE) {
                    val pageCount: Int = images.size
                    if (currentPage === 0) {
                        mViewPager!!.setCurrentItem(pageCount - 1, false)
                    } else if (currentPage === pageCount - 1) {
                        mViewPager!!.setCurrentItem(0, false)
                    }
                }
            }
        })
        val handler = Handler()
        val update = Runnable {
            if (currentPage === NUM_PAGES) {
                currentPage = 0
            }
            mViewPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 5000, 5000)

     }
*/