package com.example.myrecyclerswipe
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
class MainActivity : AppCompatActivity() {
    lateinit var courseRV: RecyclerView
    lateinit var courseRVAdapter: CourseAdapter
    lateinit var courseList: ArrayList<CourseModal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        courseRV = findViewById(R.id.idRVCourses)
        courseList = ArrayList()
        // on below line we are initializing our adapter
        courseRVAdapter = CourseAdapter(courseList, this)
        // on below line we are setting adapter to our recycler view.
        courseRV.adapter = courseRVAdapter
        // on below line we are adding data to our list
        courseList.add(CourseModal("Android Development", R.drawable.javaicon))
        courseList.add(CourseModal("C++ Development", R.drawable.javaicon))
        courseList.add(CourseModal("Java Development", R.drawable.javaicon))
        courseList.add(CourseModal("Python Development", R.drawable.javaicon))
        courseList.add(CourseModal("JavaScript Development", R.drawable.javaicon))

        // on below line we are notifying adapterthat data has been updated.
        courseRVAdapter.notifyDataSetChanged()

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                // this method is called
                // when the item is moved.
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // this method is called when we swipe our item to right direction.
                // on below line we are getting the item at a particular position.
                val deletedCourse: CourseModal =
                    courseList.get(viewHolder.adapterPosition)
               val position = viewHolder.adapterPosition
                courseList.removeAt(viewHolder.adapterPosition)

                courseRVAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                Snackbar.make(courseRV, "Deleted " + deletedCourse.courseName, Snackbar.LENGTH_LONG)
                    .setAction(
                        "Undo",
                        View.OnClickListener {
                            // adding on click listener to our action of snack bar.
                            // below line is to add our item to array list with a position.
                            courseList.add(position, deletedCourse)

                            // below line is to notify item is
                            // added to our adapter class.
                            courseRVAdapter.notifyItemInserted(position)
                        }).show()
            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(courseRV)

    }
}