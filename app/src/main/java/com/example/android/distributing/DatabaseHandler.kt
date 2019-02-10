package com.example.android.distributing

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
    private val SQL_CREATE_TABLE = "CREATE TABLE $TABLE_NAME " + "($ID Integer PRIMARY_KEY, $FIRST_NAME TEXT, $SECOND_NAME TEXT, $MOBILE_NUMBER TEXT, $PASSWORD TEXT, $NATIONALID TEXT, $DOB TEXT, $LOCATION TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertUser(user: User): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(FIRST_NAME, user.firstName)
        values.put(SECOND_NAME, user.secondName)
        values.put(PASSWORD, user.password)
        values.put(MOBILE_NUMBER, user.telNumber)
        values.put(DOB, user.birthDate)
        values.put(NATIONALID, user.nationalId)
        values.put(LOCATION, user.location)

        val _status = db.insert(TABLE_NAME, null, values)
        db.close()

        return (Integer.parseInt("$_status") != -1)
    }

    fun readAllUsers(): String {
        var allUsers: String = "";
        val db = readableDatabase
        val SELECT_ALL_QUERY = "SELECT * FROM $TABLE_NAME"
        val results = db.rawQuery(SELECT_ALL_QUERY, null)
        if (results != null) {
            if (results.moveToFirst()) {
                do {
                    var id = results.getString(results.getColumnIndex(ID))
                    var fName = results.getString(results.getColumnIndex(FIRST_NAME))
                    var sName = results.getString(results.getColumnIndex(SECOND_NAME))
                    var pword = results.getString(results.getColumnIndex(PASSWORD))
                    var mob = results.getString(results.getColumnIndex(MOBILE_NUMBER))
                    var bDate = results.getString(results.getColumnIndex(DOB))
                    var nationID = results.getString(results.getColumnIndex(NATIONALID))
                    var location = results.getString(results.getColumnIndex(LOCATION))

                    allUsers = "$allUsers \n $id $fName $sName $mob $pword $nationID $bDate $location"
                } while(results.moveToNext())
            }
        }
        results.close()
        db.close()
        return allUsers
    }

    companion object {
        private val DB_NAME="UserDB"
        private val DB_VERSION=1
        private val TABLE_NAME="users"
        private val ID="id"
        private val FIRST_NAME="FirstName"
        private val SECOND_NAME="SecondName"
        private val MOBILE_NUMBER="MobileNumber"
        private val PASSWORD="Password"
        private val NATIONALID="NationalID"
        private val DOB="BirthDate"
        private val LOCATION="Location"
    }
}