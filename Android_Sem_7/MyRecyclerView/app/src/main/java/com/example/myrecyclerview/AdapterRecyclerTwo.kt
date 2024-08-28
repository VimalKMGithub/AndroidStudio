package com.example.myrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdapterRecyclerTwo(context: Context, arrayList: ArrayList<GridPojo>) :
    RecyclerView.Adapter<AdapterRecyclerTwo.MyHolder>() {
    var context: Context
    var arrayList: ArrayList<GridPojo>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.custom_recycler_grid, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text = arrayList[position].name
        holder.image.setImageResource(arrayList[position].image)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "" + arrayList[position].name, Toast.LENGTH_SHORT).show()
        }
        holder.btn.setOnClickListener {
            arrayList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var image: ImageView
        var btn: Button

        init {
            name = view.findViewById(R.id.name)
            image = view.findViewById(R.id.image)
            btn = view.findViewById(R.id.delete)
        }
    }

    init {
        this.context = context
        this.arrayList = arrayList
    }
}