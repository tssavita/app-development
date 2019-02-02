package com.example.android.distributing

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_login.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.text.StringBuilder

class SignUpActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null

    var first_name: EditText? = null
    var second_name: EditText? = null
    var tel_number: EditText? = null
    var password: EditText? = null
    var nationalid: EditText? = null
    var location: EditText? = null

    var birthDate: TextView? = null
    var calendar = Calendar.getInstance()

    var btn_signup: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        first_name = findViewById(R.id.firstname) as EditText
        second_name = findViewById(R.id.secondname) as EditText
        tel_number = findViewById(R.id.telnumber) as EditText
        password = findViewById(R.id.text_input_password_toggle) as EditText
        nationalid = findViewById(R.id.nationalid) as EditText
        birthDate = findViewById(R.id.birthdate) as TextView
        location = findViewById(R.id.location) as EditText

        btn_signup = findViewById(R.id.btn_signup) as Button

        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {

            override fun onDateSet(view: DatePicker, year: Int, month: Int, date: Int) {
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, date)
                setDate()
            }
        }

        birthDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@SignUpActivity,
                    dateSetListener,
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.YEAR)).show()
            }
        })

        btn_signup!!.setOnClickListener {
            dashboard()
        }

    }

    override fun onOptionsItemSelected(menuitem : MenuItem) : Boolean {
        var prevIntent = Intent(applicationContext, LoginActivity::class.java)
        startActivityForResult(prevIntent, 0)
        return true
    }

    fun dashboard() {
        val dashboardIntent = Intent(this, Dashboard::class.java)
        Log.i("SignUpActivity", "first name here: " + first_name!!.text)
        val firstName = first_name!!.text
        val secondName = second_name!!.text
        dashboardIntent.putExtra("firstName", firstName)
        dashboardIntent.putExtra("secondName", secondName)
        startActivity(dashboardIntent)
    }

   fun setDate() {
        val dateFormat = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.US)
        birthDate!!.text = simpleDateFormat.format(calendar.getTime())
   }
}

