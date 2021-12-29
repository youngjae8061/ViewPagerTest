package com.example.viewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagertest.Adapters.MenuBottomAdapter
import com.example.viewpagertest.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var previewMenuItem : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager : ViewPager2 = findViewById(R.id.mVP)
        viewPager.visibility = View.VISIBLE
        val fragments: ArrayList<Fragment> = arrayListOf(
            Page1Fragment(),
            Page2Fragment(),
            Page3Fragment(),
            Page4Fragment(),
            Page5Fragment()
        )
        val adapter = ViewPagerAdapter(fragments, this)
        val menuAdapter = MenuBottomAdapter(initFragments(), supportFragmentManager)

        viewPager.adapter = adapter
        mVP2.adapter = menuAdapter
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuMain -> {
                    mVP2.currentItem = 0
                }
                R.id.menuIntro -> {
                    mVP2.currentItem = 1
                }
                R.id.menuHire -> {
                    mVP2.currentItem = 2
                }
            }
            true
        }

        mVP2.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                when(position){
                    0 -> viewPager.visibility = View.VISIBLE
                    else -> viewPager.visibility = View.GONE
                }

                if(::previewMenuItem.isInitialized){
                    previewMenuItem.setChecked(false)
                }else{
                    bottomNavigationView.menu.getItem(0).setChecked(false)
                }

                bottomNavigationView.menu.getItem(position).setChecked(true)
                previewMenuItem = bottomNavigationView.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    private fun initFragments():ArrayList<Fragment>{
        return arrayListOf(
            MainFragment(),
            IntroFragment(),
            HireFragment()
        )
    }
}
