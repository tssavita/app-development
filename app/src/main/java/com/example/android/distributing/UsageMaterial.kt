package com.example.android.distributing

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.provider.MediaStore
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_usage_material.*
import java.net.URI

class UsageMaterial : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_material)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.page)
        var adapter = SimpleTabSwitcher(supportFragmentManager)
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)
        Log.i("UsageMaterial", "Made it to the UsageMAterial Activity")
        tabLayout!!.addOnTabSelectedListener(object: TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            override fun onTabSelected(p0: TabLayout.Tab) {
                Log.i("Selected Activity", "Selected a tab")
                val tabIndex = p0.position
                viewPager!!.currentItem = tabIndex
            }

            override fun onTabReselected(p0: TabLayout.Tab) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab) {
            }


        })

    }
    override fun onOptionsItemSelected(menuitem : MenuItem) : Boolean {
        var prevIntent = Intent(applicationContext, NavigationMenu::class.java)
        startActivityForResult(prevIntent, 0)
        return true
    }

}
