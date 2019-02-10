package com.example.android.distributing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation_menu.*

class Feedback : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    var toolbar: Toolbar? = null
    var drawerLayout: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout!!.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_feedback -> {
                var feedbackActivity = Intent(applicationContext, Feedback::class.java)
                startActivity(feedbackActivity)
            }
            R.id.nav_usage -> {
                var usageActivity = Intent(applicationContext, UsageMaterial::class.java)
                startActivity(usageActivity)
            }
            R.id.nav_catalogue -> {

            }
            R.id.nav_settings -> {

            }
            R.id.nav_signout -> {
                var signoutActivity = Intent(applicationContext, LoginActivity::class.java)
                startActivity(signoutActivity)
            }
        }

        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }
}
