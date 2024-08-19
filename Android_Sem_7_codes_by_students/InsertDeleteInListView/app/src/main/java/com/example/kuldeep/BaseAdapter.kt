package com.example.kuldeep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class BaseAdapter(var context: Context, var items: ArrayList<DataModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView( position : Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        view = LayoutInflater.from(context).inflate(R.layout.listview, parent, false)

        var title = view.findViewById<TextView>(R.id.title)
        var description = view.findViewById<TextView>(R.id.description)
        var img = view.findViewById<ImageView>(R.id.img)

        title.setText(items[position].title)
        description.setText(items[position].description)
        img.setImageResource(R.drawable.insta)

        return view
    }
}