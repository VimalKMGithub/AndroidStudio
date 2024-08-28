package com.example.a01customlistviewarrayadapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyArrayAdapter(
    private var mCtx: Context,
    private var resources: Int,
    private var items: List<Model>
) :
    ArrayAdapter<Model>(mCtx, resources, items) {
    @SuppressLint("ViewHolder", "UseCompatLoadingForDrawables")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resources, null)

        val imageView = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.description)
        val mItem = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.image))
        title.text = mItem.title
        description.text = mItem.description

        return view
    }
}