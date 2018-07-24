package com.example.msi_gl62.simpelapp.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.fragment.home.FeedHomeFragment
import com.example.msi_gl62.simpelapp.fragment.lesson.FeedNewFragment
import com.example.msi_gl62.simpelapp.fragment.room.FeedRoomFragment
import kotlinx.android.synthetic.main.activity_main_tab.*

class MainTabActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tab)
        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_tab, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            val number = position
            when (number) {
                0 -> return FeedHomeFragment.newInstance("", "")
                1 -> return FeedNewFragment.newInstance("", "")
                2 -> return FeedRoomFragment.newInstance("", "")
            }

            return null
        }

        override fun getCount(): Int {
            return 3
        }
    }
}
