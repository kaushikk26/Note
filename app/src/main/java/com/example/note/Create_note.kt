package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class Create_note : AppCompatActivity() {

    lateinit var tital_createnote: TextInputEditText
    lateinit var note_createnote: TextInputEditText
    lateinit var cancel_createnote: FloatingActionButton
    lateinit var save_createnote: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_note)

        tital_createnote=findViewById(R.id.tital_createnote)
        note_createnote=findViewById(R.id.note_createnote)
        cancel_createnote=findViewById(R.id.cancel_createnote)
        save_createnote=findViewById(R.id.save_createnote)

        save_createnote.setOnClickListener {

            var dataa = Mydata(this)
            dataa.insertnote(tital_createnote.text.toString().capitalize(), note_createnote.text.toString())

            startActivity(Intent(this@Create_note,Home_page::class.java))
            finish()
        }
        cancel_createnote.setOnClickListener {
            startActivity(Intent(this@Create_note,Home_page::class.java))
            finish()
        }

    }

}