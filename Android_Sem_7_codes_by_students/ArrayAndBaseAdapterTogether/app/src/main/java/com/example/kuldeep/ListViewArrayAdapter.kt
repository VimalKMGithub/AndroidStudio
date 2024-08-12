package com.example.kuldeep

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewArrayAdapter : AppCompatActivity() {
    
    lateinit var adapter: ArrayAdapter
    var list: ArrayList<ArrayDataModel> = ArrayList()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_array_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // layout
        var listview = findViewById<ListView>(R.id.listview)
        // adapter
        listview.adapter = ArrayAdapter(this, R.layout.listviewrow, list)
        // add items
        list.add(ArrayDataModel("Facebook", "Connect with friends and family", R.drawable.fb));
        list.add(ArrayDataModel("Instagram", "Share photos and videos", R.drawable.insta));
        list.add(ArrayDataModel("Twitter", "Get the latest news and updates", R.drawable.twitter));
        list.add(ArrayDataModel("YouTube", "Watch videos and live streams", R.drawable.youtube));
        list.add(ArrayDataModel("LinkedIn", "Build your professional network", R.drawable.linkedin));
        list.add(ArrayDataModel("TikTok", "Create short-form videos", R.drawable.tiktok));
        list.add(ArrayDataModel("Snapchat", "Share photos and videos that disappear", R.drawable.snapchat));
        list.add(ArrayDataModel("Pinterest", "Discover and save ideas", R.drawable.pinterest));
        list.add(ArrayDataModel("Reddit", "Join communities and discussions", R.drawable.reddit));
        list.add(ArrayDataModel("WhatsApp", "Send messages and make calls", R.drawable.whatsapp));
        list.add(ArrayDataModel("Telegram", "Fast and secure messaging", R.drawable.telegram));
        list.add(ArrayDataModel("Discord", "Chat with friends and communities", R.drawable.discord));
        list.add(ArrayDataModel("Quora", "Ask and answer questions", R.drawable.quora));
        list.add(ArrayDataModel("Medium", "Read and write stories", R.drawable.medium));
        list.add(ArrayDataModel("Tumblr", "Post text, photos, quotes, and chat", R.drawable.tumblr));

        // on item click
        listview.setOnItemClickListener{
                parent, view, position, id ->
            val name = list[position].title

            showToast(name)

            val intent: Intent = Intent(this, ItemDetails::class.java)
            intent.putExtra("title", list[position].title)
            intent.putExtra("description", list[position].description)
            intent.putExtra("image", list[position].img)
            startActivity(intent)
        }

        // buttton to go to base adapter
        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            startActivity(Intent(this, ListViewBaseAdapter::class.java))
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