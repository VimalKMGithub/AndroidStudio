package com.example.passingdatafrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class B : Fragment() {
    private var output: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val textView = view.findViewById<TextView>(R.id.msg)
        output = arguments?.getString("message")
        textView.text = output
        return view
    }
}