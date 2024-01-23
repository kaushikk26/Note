package com.example.note

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class Edit_note : AppCompatActivity() {

    lateinit var tital_edit: TextInputEditText
    lateinit var note_edit:TextInputEditText
    lateinit var save_edit: FloatingActionButton
    lateinit var cancel_edit:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_note)
        tital_edit=findViewById(R.id.tital_editnote)
        note_edit=findViewById(R.id.note_editnote)
        save_edit=findViewById(R.id.save_editnote)
        cancel_edit=findViewById(R.id.cancel_editnote)

        var tital=intent.getStringExtra("tital")
        var note=intent.getStringExtra("note")


//        var dataa=Mydata(this)
//        var cursorr: Cursor
//        cursorr=dataa.silectnote(tital.toString())
//
////        Log.e("====", "onCreate: ${tital.toString()}", )
//
//        while (cursorr.moveToNext()) {
//            var notee = cursorr.getString(2).toString()
//            note_edit.setText(notee)
//            Log.e("====", "onCreate: $notee", )
//        }

        tital_edit.setText(tital.toString())
        note_edit.setText(note.toString())


        save_edit.setOnClickListener {


            Log.e("--++", "tital=${tital_edit.text.toString()}")
            Log.e("--++", "  --- ")
            Log.e("--++", "note=${note_edit.text.toString()}")

            var editdata=Mydata(this)
            editdata.edit(tital.toString(),tital_edit.text.toString().capitalize(),note_edit.text.toString())

            startActivity(Intent(this@Edit_note,Home_page::class.java))
            finish()
        }

        cancel_edit.setOnClickListener {
            startActivity(Intent(this@Edit_note,Home_page::class.java))
            finish()
        }

    }
}