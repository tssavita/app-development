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

    var dbHandler: DatabaseHandler? = null

    var toolbar: Toolbar? = null

    var first_name: EditText? = null
    var second_name: EditText? = null
    var tel_number: EditText? = null
    var password: EditText? = null
    var nationalid: EditText? = null
    var location: EditText? = null

    var birth_date: TextView? = null
    var calendardob = Calendar.getInstance()

    var btn_signup: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        first_name = findViewById(R.id.firstname) as EditText
        second_name = findViewById(R.id.secondname) as EditText
        tel_number = findViewById(R.id.telnumber) as EditText
        password = findViewById(R.id.text_input_password_toggle) as EditText
        nationalid = findViewById(R.id.nationalid) as EditText
        birth_date = findViewById(R.id.birthdate) as TextView
        location = findViewById(R.id.location) as EditText

        btn_signup = findViewById(R.id.btn_signup) as Button

        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {

            override fun onDateSet(view: DatePicker, year: Int, month: Int, date: Int) {
                calendardob.set(Calendar.YEAR, year)
                calendardob.set(Calendar.MONTH, month)
                calendardob.set(Calendar.DAY_OF_MONTH, date)
                setDate()
            }
        }

        birth_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@SignUpActivity,
                    dateSetListener,
                    calendardob.get(Calendar.DAY_OF_MONTH),
                    calendardob.get(Calendar.MONTH),
                    calendardob.get(Calendar.YEAR)).show()
            }
        })

        btn_signup!!.setOnClickListener {
            signup()
        }

    }

    override fun onOptionsItemSelected(menuitem : MenuItem) : Boolean {
        var prevIntent = Intent(applicationContext, LoginActivity::class.java)
        startActivityForResult(prevIntent, 0)
        return true
    }

    // TODO: Include a function for checking characters that go in every field.
    // TODO: Check if there are any characters other than alphabets in the names.
    // TODO: Add autocomplete for Location.
    fun validateInput(): Boolean {
        val firstNameString = first_name.toString()
        val secondNameString = second_name.toString()
        val telephoneInt = tel_number
        val nationalIDString = nationalid.toString()
        val passwordString = password.toString()
        val place = location.toString()

        // TODO: Check if telephoneInt gets the default +91. If yes, 1. either change that to nill, 2. don't accept +91 as meaning to have a value.
        // TODO: Check for birthdate if the default value itself gives it a non-null value.
        if (firstNameString == "" || secondNameString == "" || telephoneInt.toString() == "" ||
            nationalIDString == "" || passwordString == "" || birth_date == null || place == null
        )
            return false

        return true
    }

    fun signup() {
        if (!validateInput())
            signUpfailed()
        val user: User = User(first_name.toString(), second_name.toString(), birth_date.toString(), tel_number.toString(), nationalid.toString(), password.toString(), location.toString())
        val dbHandler: DatabaseHandler = DatabaseHandler(this)
        val _insert_status = dbHandler.insertUser(user)
        if (_insert_status) {
            Toast.makeText(baseContext, "Saved successfully", Toast.LENGTH_LONG)
            Log.i("Insert successful", "Insert successful")
        }
        dashboard()
    }

    fun signUpfailed() {
        Toast.makeText(baseContext, "Please fill up all fields", Toast.LENGTH_LONG).show()
    }

    fun ageCalculator(): Int {
        val yearNow = Calendar.getInstance().get(Calendar.YEAR)
        val dateNow = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        val birthYear = calendardob.get(Calendar.YEAR)
        val birthDay = calendardob.get(Calendar.DAY_OF_YEAR)

        var age: Int = yearNow - birthYear
        if (birthDay > dateNow)
            age -= 1

        Log.i("Age", age.toString())
        return age
    }

    fun dashboard() {
        val dashboardIntent = Intent(this, NavigationMenu::class.java)
        Log.i("SignUpActivity", "first name here: " + first_name!!.text)
        val firstName = first_name!!.text.toString()
        val secondName = second_name!!.text.toString()
        val birthDate = birth_date!!.text.toString()
        dashboardIntent.putExtra("firstName", firstName)
        dashboardIntent.putExtra("secondName", secondName)
        dashboardIntent.putExtra("dob", ageCalculator().toString())
        startActivity(dashboardIntent)
    }

   fun setDate() {
        val dateFormat = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.US)
        birth_date!!.text = simpleDateFormat.format(calendardob.getTime())
   }
}

