package com.example.android.distributing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_navigation_menu.*
import kotlinx.android.synthetic.main.app_bar_navigation_menu.*

class Dashboard : AppCompatActivity() {

    var username: TextView? = null
    var toolbar: android.support.v7.widget.Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        //getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        username = findViewById(R.id.username)
        displayUsername()
        username!!.setOnClickListener {
            displayUsageMaterial()
        }
    }

    fun displayMenu() {
        startActivity(Intent(applicationContext, NavigationMenu::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        displayMenu()
        return true
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }*/



    fun displayUsername() {
        var userInformation = intent.extras
        var firstName = userInformation!!["firstName"]
        var secondName = userInformation!!["secondName"]
        Log.i("DashboardActivity", "Printing firstname received in dashboard: " + firstName)
        username!!.setText(firstName.toString() + " " + secondName)
    }

    fun displayUsageMaterial() {
        var usageMaterialIntent = Intent(this, UsageMaterial::class.java)
        startActivity(usageMaterialIntent)
    }

    override fun onOptionsItemSelected(menuitem : MenuItem) : Boolean {
        var prevIntent = Intent(applicationContext, SignUpActivity::class.java)
        startActivityForResult(prevIntent, 0)
        return true
    }
}
