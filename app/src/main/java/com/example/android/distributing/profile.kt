package com.example.android.distributing

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class profile : AppCompatActivity() {

    var toolbar: Toolbar? = null

    var user: User? = null
    var doneButton: Button? = null
    var first_name: EditText? = null
    var second_name: EditText? = null
    var tel_number: EditText? = null
    var password: EditText? = null
    var nationalid: EditText? = null
    var location: EditText? = null

    var calendardob = Calendar.getInstance()
    var birth_date: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        user = intent.extras.get("user") as User

        first_name = findViewById(R.id.firstname) as EditText
        second_name = findViewById(R.id.secondname) as EditText
        tel_number = findViewById(R.id.telnumber) as EditText
        password = findViewById(R.id.text_input_password_toggle) as EditText
        nationalid = findViewById(R.id.nationalid) as EditText
        birth_date = findViewById(R.id.birthdate) as TextView
        location = findViewById(R.id.location) as EditText

        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        populateCurrentDetails(user!!)

        doneButton = findViewById(R.id.btn_editdone)

        doneButton!!.setOnClickListener {
            displayDashboardAgain()
        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {

            override fun onDateSet(view: DatePicker, year: Int, month: Int, date: Int) {

                calendardob.set(Calendar.YEAR, year)
                calendardob.set(Calendar.MONTH, month)
                calendardob.set(Calendar.DAY_OF_MONTH, date)
                birth_date!!.text = calendarToString(calendardob)
            }
        }

        birth_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@profile,
                    dateSetListener,
                    calendardob.get(Calendar.DAY_OF_MONTH),
                    calendardob.get(Calendar.MONTH),
                    calendardob.get(Calendar.YEAR)).show()
            }
        })
    }

    fun populateCurrentDetails(user: User) {
        first_name!!.setText(user.firstName)
        second_name!!.setText(user.secondName)
        tel_number!!.setText(user.telNumber)
        password!!.setText(user.password)
        nationalid!!.setText(user.nationalId)
        location!!.setText(user.stayPlace)
        birth_date!!.text = user.birthDate
    }

    fun updateProfile() {
        user!!.firstName = first_name!!.text.toString()
        user!!.secondName = second_name!!.text.toString()
        user!!.telNumber = tel_number!!.text.toString()
        user!!.nationalId = nationalid!!.text.toString()
        user!!.password = password!!.text.toString()
        user!!.location = location!!.text.toString()
        user!!.birthDate = birth_date!!.text.toString()
    }

    fun displayDashboardAgain() {
        val dashboardIntent = Intent(this, NavigationMenu::class.java)
        Log.i("SignUpActivity", "first name here: " + first_name!!.text)
        updateProfile()
        dashboardIntent.putExtra("user", user as User)
        startActivity(dashboardIntent)
    }

    fun calendarToString(calendardob: Calendar): String {
        val dateFormat = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.US)
        return simpleDateFormat.format(calendardob.getTime())
    }

    fun stringToCalendar(birthDate: String): Calendar {
        var cal = Calendar.getInstance()
        var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        cal.setTime(sdf.parse(birthDate))
        return cal
    }
}
