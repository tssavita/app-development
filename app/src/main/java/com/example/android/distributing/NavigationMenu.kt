package com.example.android.distributing

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.R.*
import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.DrawerLayout
import android.text.Layout
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_navigation_menu.*
import kotlinx.android.synthetic.main.app_bar_navigation_menu.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class NavigationMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var dob: Any? = null
    var toolbar: Toolbar? = null
    var welcometext: TextView? = null
    var agelocation: TextView? = null
    var drawer_layout: DrawerLayout? = null
    var firstName: Any? = null
    var secondName: Any? = null
    var user: User? = null
    var editPencil: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_menu)
        welcometext = findViewById(R.id.welcomeText)
        agelocation = findViewById(R.id.age_location)
        toolbar = findViewById(R.id.toolbar)
        drawer_layout = findViewById(R.id.drawer_layout)
        editPencil = findViewById(R.id.fab)
        setSupportActionBar(toolbar)
        //getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        user = intent.extras.get("user") as User
        displayProfile()

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout!!.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.itemIconTintList = null

        editPencil!!.setOnClickListener {
            editProfile()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
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
                var dashboardActivity = Intent(applicationContext, NavigationMenu::class.java)
                startActivity(dashboardActivity)
            }
            R.id.nav_signout -> {
                var signoutActivity = Intent(applicationContext, LoginActivity::class.java)
                startActivity(signoutActivity)
            }
        }

        drawer_layout!!.closeDrawer(GravityCompat.START)
        return true
    }

    fun displayProfile() {
        Log.i("welcometext", welcometext!!.text.toString())
        Log.i("firstname", user!!.firstName)
        Log.i("secondname", user!!.secondName)
        val welcomeText: String = welcometext!!.text.toString() + user!!.firstName + " " + user!!.secondName
        welcometext!!.setText(welcomeText)
        var birthDate = stringToCalendar(user!!.birthDate)
        var age = Utils.ageCalculator(birthDate)
        Log.i("DashboardActivity", "Printing firstname received in dashboard: " + welcomeText)
        agelocation!!.setText(age.toString() + " | " + user!!.stayPlace)
        Log.i("Location", user!!.location)
    }

    fun editProfile() {
        Log.i("editProfile", "Editing Profile aCtivity")
        var editProfileIntent = Intent(this, profile::class.java)
        editProfileIntent.putExtra("user", user as User)
        startActivity(editProfileIntent)
    }

    fun displayUsageMaterial() {
        var usageMaterialIntent = Intent(this, UsageMaterial::class.java)
        usageMaterialIntent.putExtra("user", user as User)
        startActivity(usageMaterialIntent)
    }

    fun stringToCalendar(birthDate: String): Calendar {
        var cal = Calendar.getInstance()
        var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        cal.setTime(sdf.parse(birthDate))
        return cal
    }
}
