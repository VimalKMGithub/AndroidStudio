package com.example.datetime

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var seda: Button
    private lateinit var seti: Button
    private lateinit var tvda: TextView
    private lateinit var tvti: TextView
    private lateinit var cale: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cale = Calendar.getInstance()

        seda = findViewById(R.id.seda)
        tvda = findViewById(R.id.tvda)

        seda.setOnClickListener {
            val d = cale.get(Calendar.DAY_OF_MONTH)
            val m = cale.get(Calendar.MONTH)
            val y = cale.get(Calendar.YEAR)

            DatePickerDialog(this, { _, sy, sm, sd ->
                tvda.text = String.format("%02d/%02d/%04d", sd, sm, sy)
            }, y, m, d).show()
        }

        seti = findViewById(R.id.seti)
        tvti = findViewById(R.id.tvti)

        seti.setOnClickListener {
            val h = cale.get(Calendar.HOUR_OF_DAY)
            val m = cale.get(Calendar.MINUTE)

            TimePickerDialog(this, { _, sh, sm ->
                tvti.text = String.format("%02d:%02d", sh, sm)
            }, h, m, true).show()
        }
    }
}