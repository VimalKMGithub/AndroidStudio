package com.example.staticpassfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class F2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_f2, container, false)
        val tv = view.findViewById<TextView>(R.id.tv)
        tv.text = arguments?.getString("Mes")
        return view
    }
}