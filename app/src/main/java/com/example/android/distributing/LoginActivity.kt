package com.example.android.distributing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var edt_telnumber: EditText? = null
    var edt_password: EditText? = null
    var btn_login: Button? = null
    var txt_signup: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_telnumber = findViewById(R.id.telnumber) as EditText
        edt_password = findViewById(R.id.password) as EditText
        btn_login = findViewById(R.id.btn_login) as Button
        txt_signup = findViewById(R.id.signup) as TextView

        btn_login!!.setOnClickListener{
            login()
        }

        txt_signup!!.setOnClickListener{
            signup()
        }
    }

    fun login() {
        Log.d("LoginActivity","Login")
        if (!validate_input()) {
            login_failed()
            return
        }
        btn_login!!.isEnabled = false
        val telnumber = edt_telnumber!!.text.toString()
        val password = edt_password!!.text.toString()

        if (telnumber.equals("9876543210") && password.equals("blahblah"))
            login_succeeded()
    }

    fun login_succeeded() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun login_failed() {
        Toast.makeText(baseContext, "Login Failed", Toast.LENGTH_LONG).show()
    }

    fun validate_input(): Boolean {
        val telnumber = edt_telnumber!!.text
        val password = edt_password!!.text
        if (telnumber.isEmpty() || !android.util.Patterns.PHONE.matcher(telnumber).matches())
            return false
        if (password.isEmpty() || password.length < 8 || password.length > 12) {
            return false
        }
        return true
    }

    fun signup() {
        
    }
}
