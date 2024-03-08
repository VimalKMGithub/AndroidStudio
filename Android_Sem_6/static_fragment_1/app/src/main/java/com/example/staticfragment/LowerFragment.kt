package com.example.staticfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LowerFragment : Fragment() {
    private var output: String ?= ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_lower, container, false)
        val textView: TextView = view.findViewById(R.id.msg)
        output=arguments?.getString("message")
        textView.text=output
        return view
    }
}