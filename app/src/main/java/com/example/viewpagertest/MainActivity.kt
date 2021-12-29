package com.example.viewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager : ViewPager2 = findViewById(R.id.mVP)

        val fragments: ArrayList<Fragment> = arrayListOf(
            Page1Fragment(),
            Page2Fragment(),
            Page3Fragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

    }


}