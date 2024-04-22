package com.example.myrecyclerswipe
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter (
    private val courseList: ArrayList<CourseModal>,private val context: Context
    ):RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CourseAdapter.CourseViewHolder {
            // this method is use to inflate the layout file which we have created for our recycler view.
            // on below line we are inflating our layout file.
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.course_item,
                parent, false
            )
            // at last we are returning our view holder class with our item View File.
            return CourseViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
            // on below line we are setting data to our text view and our image view.
            holder.courseNameTV.text = courseList.get(position).courseName
            holder.courseIV.setImageResource(courseList.get(position).courseImg)
        }

        override fun getItemCount(): Int {
            // on below line we are returning
            // our size of our list
            return courseList.size
        }

        class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // on below line we are initializing our course name
            // text view and our image view.
            val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
            val courseIV: ImageView = itemView.findViewById(R.id.idIVCourse)
        }
    }
