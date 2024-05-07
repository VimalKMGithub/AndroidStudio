package com.example.staticpassfrag

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Common {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fc, F1()).commit()
    }

    override fun pass(str: String) {
        val b = Bundle()
        b.putString("Mes", str)
        val ft = F2()
        ft.arguments = b
        supportFragmentManager.beginTransaction().replace(R.id.fc, ft).commit()

    }
}