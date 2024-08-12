package com.example.customarrayadaptor

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class CustomGridViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_grid_view_example)
        val gridView = findViewById<GridView>(R.id.gridView)

        val arrayListImage = ArrayList<Int>()

        arrayListImage.add(R.drawable.ic_launcher_background)
        arrayListImage.add(R.drawable.ic_launcher_background)
        arrayListImage.add(R.drawable.ic_launcher_background)
        arrayListImage.add(R.drawable.ic_launcher_background)
        arrayListImage.add(R.drawable.ic_launcher_background)

        val name = arrayOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread")

//        val customAdapter = CustomGridAdapter(this@CustomGridViewExample, arrayListImage, name)
    }
}