package com.example.kuldeep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ArrayAdapter (var mCtx: Context, var resources: Int, var items: List<ArrayDataModel>) : ArrayAdapter<ArrayDataModel>(mCtx, resources, items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resources, null)

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