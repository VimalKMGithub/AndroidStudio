package com.example.sqlquestion

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val context: Context, private val cursor: Cursor) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val slNoTextView: TextView = itemView.findViewById(R.id.sl_no)
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val mobileTextView: TextView = itemView.findViewById(R.id.mobile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (cursor.moveToPosition(position)) {
            val slNo = cursor.getInt(cursor.getColumnIndexOrThrow("sl_no"))
            val firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name"))
            val lastName = cursor.getString(cursor.getColumnIndexOrThrow("last_name"))
            val mobile = cursor.getString(cursor.getColumnIndexOrThrow("mobile_number"))

            holder.slNoTextView.text = slNo.toString()
            holder.nameTextView.text = "$firstName $lastName"
            holder.mobileTextView.text = mobile
        }
    }

    override fun getItemCount(): Int {
        return cursor.count
    }
}