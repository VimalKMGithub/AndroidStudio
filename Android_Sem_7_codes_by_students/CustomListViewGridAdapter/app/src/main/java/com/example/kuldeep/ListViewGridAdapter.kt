package com.example.kuldeep

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewGridAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_grid_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var gridView = findViewById<GridView>(R.id.gridview)

        var listOfImages = ArrayList<Int>()
        var listOfNames = ArrayList<String>()

        listOfImages.add(R.drawable.user1)
        listOfImages.add(R.drawable.user2)
        listOfImages.add(R.drawable.user3)
        listOfImages.add(R.drawable.user4)
        listOfImages.add(R.drawable.user5)
        listOfImages.add(R.drawable.user6)
        listOfImages.add(R.drawable.user2)
        listOfImages.add(R.drawable.user1)
        listOfImages.add(R.drawable.user4)
        listOfImages.add(R.drawable.user5)
        listOfImages.add(R.drawable.user3)
        listOfImages.add(R.drawable.user6)
        listOfImages.add(R.drawable.user2)
        listOfImages.add(R.drawable.user1)
        listOfImages.add(R.drawable.user4)

        listOfNames.add("Akanksha Sharma")
        listOfNames.add("Aakriti Saxena")
        listOfNames.add("Shraddha Gupta")
        listOfNames.add("Rashi Roy")
        listOfNames.add("Subham Ray")
        listOfNames.add("Chaitanya Krishna")
        listOfNames.add("Aakriti Saxena")
        listOfNames.add("Akanksha Sharma")
        listOfNames.add("Rashi Roy")
        listOfNames.add("Subham Ray")
        listOfNames.add("Shraddha Gupta")
        listOfNames.add("Chaitanya Krishna")
        listOfNames.add("Aakriti Saxena")
        listOfNames.add("Akanksha Sharma")
        listOfNames.add("Rashi Roy")

        gridView.adapter = GridAdapter(this, listOfImages, listOfNames)

        gridView.setOnItemClickListener { parent, view, position, id ->
            showToast(listOfNames[position])
        }

    }
    // cancel previous toast and show latest one
    private var toast: Toast? = null;
    fun showToast(message: String){
        if(toast != null){
            toast?.cancel()
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

}