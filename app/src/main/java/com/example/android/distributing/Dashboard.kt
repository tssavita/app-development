package com.example.android.distributing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView

class Dashboard : AppCompatActivity() {

    var username: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        username = findViewById(R.id.username)
        displayUsername()
        username!!.setOnClickListener {
            displayUsageMaterial()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflate = getMenuInflater()
        menuInflate.inflate(R.menu.example_menu, menu)
        return true
    }

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
}
