package com.example.x

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var datePickerButton: Button
    private lateinit var selectedDateTextView: TextView
    private lateinit var timePickerButton: Button
    private lateinit var selectedTimeTextView: TextView
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePickerButton = findViewById(R.id.se)
        selectedDateTextView = findViewById(R.id.tv)

        calendar = Calendar.getInstance()

        datePickerButton.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                this, { _, selectedYear, selectedMonth, selectedDay ->
                    val dateSe = String.format(
                        "%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear
                    )
                    dateSe.also { selectedDateTextView.text = it }
                }, year, month, day
            ).show()
        }

        timePickerButton = findViewById(R.id.se1)
        selectedTimeTextView = findViewById(R.id.tv1)

        timePickerButton.setOnClickListener {
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            TimePickerDialog(
                this, { _, selectedHour, selectedMinute ->
                    val timeSe = String.format("%02d:%02d", selectedHour, selectedMinute)
                    selectedTimeTextView.text = timeSe
                }, hour, minute, true
            ).show()
        }
    }
}