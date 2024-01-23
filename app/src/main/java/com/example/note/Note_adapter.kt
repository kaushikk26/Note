package com.example.note


import android.database.Cursor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.PopupMenu
import android.widget.TextView

class Note_adapter(
    var homePage: Home_page,
    var list: ArrayList<Note_data>
) : BaseAdapter() {




    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        var tital_titalview: TextView
        var edit_titalview: TextView
        var view = LayoutInflater.from(homePage).inflate(R.layout.tital_view, parent, false)

        tital_titalview = view.findViewById(R.id.titalview_tital)

        Log.e("------check", "getView: ${list.get(position).tital1}")

        tital_titalview.setText(list[position].tital1)

        edit_titalview = view.findViewById(R.id.edit_titalview)




        edit_titalview.setOnClickListener {
            var popoup = PopupMenu(homePage, edit_titalview)
            popoup.menuInflater.inflate(R.menu.popup_manu, popoup.menu)

            popoup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.delete_popup -> {
                        var delete_note = Mydata(homePage)
                        delete_note.delete(tital_titalview.text.toString())
                        list.removeAt(position)
                        notifyDataSetChanged()

                    }
                }
                true
            }

            popoup.show()

        }



        return view
    }

}
