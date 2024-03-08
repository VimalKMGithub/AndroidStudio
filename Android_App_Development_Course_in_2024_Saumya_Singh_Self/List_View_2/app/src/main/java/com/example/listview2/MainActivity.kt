package com.example.listview2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = arrayOf("Saumya", "Prastuti", "Ankit", "Pradeep", "Aman")
        val lastMsg = arrayOf("Hey wssup", "I am fine", "Good", "Awesome", "Cool")
        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")
        val phoneNumber =
            arrayOf("7878778956", "9865325412", "8552634174", "6251849562", "7845125623")
        val imgId = arrayOf(
            R.drawable.pic5,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4
        )
        userArrayList = ArrayList()
        for (eachIndex in name.indices) {
            val user = User(
                name[eachIndex],
                lastMsg[eachIndex],
                lastMsgTime[eachIndex],
                phoneNumber[eachIndex],
                imgId[eachIndex]
            )
            userArrayList.add(user)
        }
        binding.listView.isClickable = true
        binding.listView.adapter = MyAdapter(this, userArrayList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val userName=name[position]
            val userPhone=phoneNumber[position]
            val imgId=imgId[position]

            val i =Intent(this,UserActivity::class.java)
            i.putExtra("name",userName)
            i.putExtra("phone",userPhone)
            i.putExtra("imgId",imgId)
            startActivity(i)
        }
    }
}