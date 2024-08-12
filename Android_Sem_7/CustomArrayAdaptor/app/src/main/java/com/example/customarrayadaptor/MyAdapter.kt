package com.example.customarrayadaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx: Context, var resources: Int, var items: List<Model>) :
    ArrayAdapter<Model>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)
        val imageView: ImageView = view.findViewById(R.id.image)
        val textViewTitle: TextView = view.findViewById(R.id.textview1)
        val description: TextView = view.findViewById(R.id.textview2)

        val mItem: Model = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.image))
        textViewTitle.text = mItem.title
        description.text = mItem.description

        return view
    }
}