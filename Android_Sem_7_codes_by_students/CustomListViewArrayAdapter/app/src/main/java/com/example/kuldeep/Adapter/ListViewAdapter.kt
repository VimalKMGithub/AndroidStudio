package com.example.kuldeep.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.kuldeep.Model
import com.example.kuldeep.R

class ListViewAdapter(var mCtx: Context, var resourses: Int, var items: List<Model>) : ArrayAdapter<Model>(mCtx, resourses, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resourses, null)

        var imageView = view.findViewById<ImageView>(R.id.img)
        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.description)

        val mItem = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        title.text = mItem.title
        description.text = mItem.description

        return view
    }

}