package com.example.myapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Home : Fragment() {
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var calculateBtn: Button
    private lateinit var reCalculateBtn: Button
    private lateinit var bmiTextView: TextView
    private lateinit var bmiResultTextView: TextView
    private lateinit var statusTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        etHeight = view.findViewById(R.id.etHeight)
        etWeight = view.findViewById(R.id.etWeight)
        calculateBtn = view.findViewById(R.id.calculate_btn)
        reCalculateBtn = view.findViewById(R.id.ReCalculate)
        bmiTextView = view.findViewById(R.id.bmi_tv)
        bmiResultTextView = view.findViewById(R.id.bmi)
        statusTextView = view.findViewById(R.id.status)

        calculateBtn.setOnClickListener {
            if (etHeight.text.isNotEmpty() && etWeight.text.isNotEmpty()) {
                hideKeyboard()
                val height = etHeight.text.toString().toInt()
                val weight = etWeight.text.toString().toInt()
                val bmi = calculateBMI(height, weight)

                bmiResultTextView.text = bmi.toString()
                bmiResultTextView.visibility = View.VISIBLE

                if (bmi < 18.5) {
                    statusTextView.text = "Under Weight"
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    statusTextView.text = "Healthy"
                } else if (bmi >= 24.9 && bmi < 30) {
                    statusTextView.text = "Overweight"
                } else if (bmi >= 30) {
                    statusTextView.text = "Suffering from Obesity"
                }

                bmiTextView.visibility = View.VISIBLE
                statusTextView.visibility = View.VISIBLE

                reCalculateBtn.visibility = View.VISIBLE
                calculateBtn.visibility = View.GONE

            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter valid height and weight",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        reCalculateBtn.setOnClickListener {
            resetEverything()
        }

        return view
    }

    private fun resetEverything() {
        calculateBtn.visibility = View.VISIBLE
        reCalculateBtn.visibility = View.GONE

        etHeight.text.clear()
        etWeight.text.clear()
        statusTextView.text = ""
        bmiResultTextView.text = ""
        bmiTextView.visibility = View.GONE
    }

    private fun calculateBMI(height: Int, weight: Int): Float {
        val heightInMeter = height.toFloat() / 100
        return weight.toFloat() / (heightInMeter * heightInMeter)
    }

    private fun hideKeyboard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view: View? = activity?.currentFocus
        view?.let {
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}