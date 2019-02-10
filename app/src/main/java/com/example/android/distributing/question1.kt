package com.example.android.distributing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class question1 : AppCompatActivity() {

    var nextButton: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        nextButton = findViewById(R.id.next_arrow)
        nextButton!!.setOnClickListener() {
            nextQuestion()
        }
    }

    public fun nextQuestion() {
        Log.i("Question 1", "question1")
        var nextIntent = Intent(applicationContext, question2::class.java)
        startActivity(nextIntent)
    }
}
