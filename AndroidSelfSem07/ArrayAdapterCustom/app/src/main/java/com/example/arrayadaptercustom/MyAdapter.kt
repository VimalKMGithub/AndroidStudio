package com.example.arrayadaptercustom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(
    private var context: Context,
    private var resources: Int,
    private var items: List<Model>
) :
    ArrayAdapter<Model>(context, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(resources, null)

        val image = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.description)

        val item = items[position]
        image.setImageDrawable(context.resources.getDrawable(item.image))
        title.text = item.title
        description.text = item.description

        return view
    }
}