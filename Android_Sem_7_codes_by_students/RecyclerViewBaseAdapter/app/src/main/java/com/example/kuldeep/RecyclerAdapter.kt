package com.example.kuldeep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context, val arrayList: ArrayList<DataModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = arrayList[position]
        holder.versionName.text = item.versionName
        holder.version.text = item.version
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val versionName: TextView = view.findViewById(R.id.versionName)
        val version: TextView = view.findViewById(R.id.version)
    }


}
