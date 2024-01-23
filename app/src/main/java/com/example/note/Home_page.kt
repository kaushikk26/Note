package com.example.note

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener

class Home_page : AppCompatActivity() {

    lateinit var serch_home: SearchView
    lateinit var list_view_home: ListView
    lateinit var add_note_home: ImageView

    companion object {
        var listof_tital_home = ArrayList<Note_data>()
        var list = ArrayList<Note_data>()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        serch_home = findViewById(R.id.search_home)
        list_view_home = findViewById(R.id.listview_home)
        add_note_home = findViewById(R.id.add_note_home)

        var titals = Mydata(this)
        listof_tital_home.clear()


        var cursor: Cursor
        cursor = titals.select_tital()

        while (cursor.moveToNext()) {
            var tital1 = cursor.getString(1).toString()
            var note1 = cursor.getString(2).toString()

            var data = Note_data(tital1, note1)

            listof_tital_home.add(data)

        }
        Log.e("-------oooooppp", "onCreateeee: $listof_tital_home" , )
        list.clear()
        var arrey = ArrayList<String>()
        arrey.clear()
        for (i in 0 until listof_tital_home.size) {
            arrey.add(listof_tital_home[i].tital1)

        }
        arrey.sort()

        for (i in 0 until listof_tital_home.size) {
            for (j in 0 until listof_tital_home.size) {
                if (arrey[i] == listof_tital_home[j].tital1) {
                    list.add(listof_tital_home[j])
                }
            }
        }
        listof_tital_home.clear()
        for (i in 0 until list.size){
            listof_tital_home.add(list[i])
        }
        Log.e("////", "onCreate: $listof_tital_home", )


        var adapter = Note_adapter(this, listof_tital_home)
        list_view_home.adapter = adapter

        Log.e("---ooppp", "onCreate: 2", )


        add_note_home.setOnClickListener {
            startActivity(Intent(this@Home_page, Create_note::class.java))
            finish()
        }
        list_view_home.setOnItemClickListener { parent, view, pos, id ->


            var intent = Intent(this@Home_page, Edit_note::class.java)
            startActivity(
                intent.putExtra("tital", listof_tital_home.get(pos).tital1)
                    .putExtra("note",listof_tital_home.get(pos).note1)
            )
        }
        serch_home.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                var serchtext = ArrayList<Note_data>()
                for (i in 0 until listof_tital_home.size) {
                    var titale = listof_tital_home[i].tital1
                    if (titale.toString().toLowerCase()
                            .contains(newText.toString().toLowerCase())
                    ) {
                        serchtext.add(listof_tital_home[i])
                    }
                }
//                Log.e("---", "after serch $list")

                var adapter = Note_adapter(this@Home_page, serchtext)
                list_view_home.adapter = adapter

                return true
            }

        })

    }
}