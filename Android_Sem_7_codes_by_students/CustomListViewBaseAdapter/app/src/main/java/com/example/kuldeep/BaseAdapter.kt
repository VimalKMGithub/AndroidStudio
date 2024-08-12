package com.example.kuldeep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class BaseAdapter (private val context: Context, private val arrayList: ArrayList<Model>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        view = LayoutInflater.from(context).inflate(R.layout.rowbase, parent, false)

        val img = view.findViewById<ImageView>(R.id.img)
        val name = view.findViewById<TextView>(R.id.name)
        val number = view.findViewById<TextView>(R.id.number)

        img.setImageResource(arrayList[position].img)
        name.text = arrayList[position].name
        number.text = arrayList[position].mobileNumber

        img.setOnClickListener {
            showToast("${name.text} ${number.text}")
        }

        return view
    }

    private var toast: Toast? = null;
    fun showToast(message: String){
        if(toast != null){
            toast?.cancel()
        }
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

}