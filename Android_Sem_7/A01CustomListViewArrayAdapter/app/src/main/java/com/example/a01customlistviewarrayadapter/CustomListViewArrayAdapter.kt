package com.example.a01customlistviewarrayadapter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomListViewArrayAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_array_adapter)

        val listView = findViewById<ListView>(R.id.listview)
        val list = mutableListOf<Model>()

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
        list.add(Model("Skype", "Video calls and messaging", R.drawable.skype));

        listView.adapter = MyArrayAdapter(this, R.layout.listviewrow, list)
        listView.setOnItemClickListener { _: AdapterView<*>, _: View, position: Int, _: Long ->
            showToast(list[position].title)
        }
    }

    private var toast: Toast? = null
    private fun showToast(message: String) {
        if (toast != null) {
            toast?.cancel()
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }
}