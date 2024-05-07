package com.example.newshared

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ets: EditText
    private lateinit var tvs: TextView
    private lateinit var sv: Button
    private lateinit var lo: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ets = findViewById(R.id.ets)
        tvs = findViewById(R.id.tvs)
        sv = findViewById(R.id.sv)
        lo = findViewById(R.id.lo)

        sv.setOnClickListener {
            try {
                val fOp = openFileOutput("d.txt", MODE_APPEND)
                fOp.write(ets.text.toString().toByteArray())
                fOp.close()
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        lo.setOnClickListener {
            try {
                val fIn = openFileInput("d.txt")
                var ch = ""
                var co: Int
                while (fIn.read().also { co = it } != -1) {
                    ch += co.toChar().toString()
                }
                tvs.text = ch
                fIn.close()
                Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}