package com.example.android.distributing

import android.support.constraint.Placeholder
import java.io.Serializable
import java.util.*

class User(val fName: String,
           val sName: String,
           val bDate: String,
           val tNumber: String,
           val ntnlId: String,
           val pword: String,
           val stayPlace: String): Serializable {
    var id: Int = 0
    var firstName: String
    var secondName: String
    var birthDate: String
    var telNumber: String
    var nationalId: String
    var password: String
    var location: String

    init {
        firstName = fName
        secondName = sName
        birthDate = bDate
        telNumber = tNumber
        nationalId = ntnlId
        password = pword
        location = stayPlace
    }
}