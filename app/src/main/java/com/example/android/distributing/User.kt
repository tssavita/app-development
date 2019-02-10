package com.example.android.distributing

import java.util.*

class User(val fName: String,
           val sName: String,
           val bDate: String,
           val tNumber: String,
           val ntnlId: String,
           val pword: String,
           val place: String) {
    val id: Int = 0
    val firstName: String
    val secondName: String
    val birthDate: String
    val telNumber: String
    val nationalId: String
    val password: String
    val location: String

    init {
        firstName = fName
        secondName = sName
        birthDate = bDate
        telNumber = tNumber
        nationalId = ntnlId
        password = pword
        location = place
    }
}