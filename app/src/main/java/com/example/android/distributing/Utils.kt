package com.example.android.distributing

import android.util.Log
import java.util.*

object Utils {
    fun ageCalculator(calendardob: Calendar): Int {
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
}