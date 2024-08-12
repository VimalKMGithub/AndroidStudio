package com.example.kuldeep

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuldeep.Adapter.ListViewAdapter

class CustomListViewArrayAdapter : AppCompatActivity() {

    lateinit var adapter: CustomListViewArrayAdapter
    var list: ArrayList<Model> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view_array_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var listView = findViewById<ListView>(R.id.listview)
        listView.adapter = ListViewAdapter(this, R.layout.listviewrow, list)

        // add items in list
        list.add(Model("Facebook", "Connect with friends and family", R.drawable.fb));
        list.add(Model("Instagram", "Share photos and videos", R.drawable.insta));
        list.add(Model("Twitter", "Get the latest news and updates", R.drawable.twitter));
        list.add(Model("YouTube", "Watch videos and live streams", R.drawable.youtube));
        list.add(Model("LinkedIn", "Build your professional network", R.drawable.linkedin));
        list.add(Model("TikTok", "Create short-form videos", R.drawable.tiktok));
        list.add(Model("Snapchat", "Share photos and videos that disappear", R.drawable.snapchat));
        list.add(Model("Pinterest", "Discover and save ideas", R.drawable.pinterest));
        list.add(Model("Reddit", "Join communities and discussions", R.drawable.reddit));
        list.add(Model("WhatsApp", "Send messages and make calls", R.drawable.whatsapp));
        list.add(Model("Telegram", "Fast and secure messaging", R.drawable.telegram));
        list.add(Model("Discord", "Chat with friends and communities", R.drawable.discord));
        list.add(Model("Quora", "Ask and answer questions", R.drawable.quora));
        list.add(Model("Medium", "Read and write stories", R.drawable.medium));
        list.add(Model("Tumblr", "Post text, photos, quotes, and chat", R.drawable.tumblr));

        // done with adapter
        
        // add onclick listener to all items (show toast and navigate to new activity
        listView.setOnItemClickListener { parent, view, position, id ->
            // show toast
            showToast(list[position].title)

            // intent
            val intent = Intent(this, ShowItemDetail::class.java)
            // add item details to intent to pass into the next (ShowItemDetail) activity
            intent.putExtra("title", list[position].title)
            intent.putExtra("description", list[position].description)
            intent.putExtra("image", list[position].img)

            // start intent
            startActivity(intent)
        }
    }

    // create showToast function to cancel previous toast and show latest
    var toast: Toast? = null
    fun showToast(message: String){
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }
}