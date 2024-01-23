package com.example.note

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import kotlin.Exception

class Mydata(context: Context): SQLiteOpenHelper(context,"data",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var table="create table my_table (ID INTEGER PRIMARY KEY AUTOINCREMENT ,TITAL text  ,NOTE text )"
        db?.execSQL(table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertnote(tital_createnote: String, note_createnote: String) {
        var insert="insert into my_table (TITAL,NOTE)values ('$tital_createnote','$note_createnote')"

        try {
            writableDatabase.execSQL(insert)
            Log.e("kkkkkk", "insertnote: ", )
        }catch (e :Exception){

        }
    }

    fun select_tital(): Cursor {
        var cursor:Cursor
        var silecttital="select * from my_table"

        cursor=readableDatabase.rawQuery(silecttital,null)
        return cursor
    }

    fun edit(tital: String, tital_edit: String, note_edit: String) {
        var edit="update my_table set TITAL='$tital_edit' , NOTE='$note_edit' where TITAL='$tital'"
        try {
            writableDatabase.execSQL(edit)
        }catch (e:Exception){

        }
    }

    fun delete(tital_titalview: String) {
        var delite="delete from my_table where TITAL ='$tital_titalview'"
        writableDatabase.execSQL(delite)
    }

    fun silectnote(titleee: String): Cursor {

        var cursorr:Cursor
        var silectnote="select * from my_table where TITAL='$titleee'"

        cursorr=readableDatabase.rawQuery(silectnote,null)
        return cursorr
    }

}
