package com.example.kuldeep

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.zip.Inflater

class GridAdapter(var context: Context, var listOfImages: ArrayList<Int>,var listOfNames: ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return listOfImages.size
    }

    override fun getItem(p0: Int): Any {
        return listOfImages.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var holder: ViewHolder

        if(view == null){

            val inflater = (context as Activity).layoutInflater
            view = inflater.inflate(R.layout.grid_item, parent, false)
            holder = ViewHolder()

            holder.img = view.findViewById(R.id.img) as ImageView
            holder.title = view.findViewById(R.id.title) as TextView
            view.tag = holder
        }else{
            holder = view.tag as ViewHolder
        }

        holder.img?.setImageResource(listOfImages.get(position))
        holder.title?.setText(listOfNames.get(position))

        return view!!
    }

    class ViewHolder{
        var img: ImageView? = null
        var title: TextView? = null
    }
}
