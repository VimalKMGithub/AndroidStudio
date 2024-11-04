package com.example.sqlliteq2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter(private val context: Context, private val users: List<User>) : BaseAdapter() {

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return users[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.customlook, parent, false)
        val user = users[position]

        val imageView = view.findViewById<ImageView>(R.id.userImage)
        val nameView = view.findViewById<TextView>(R.id.userName)

        imageView.setImageBitmap(user.image)
        nameView.text = user.name

        return view
    }
}