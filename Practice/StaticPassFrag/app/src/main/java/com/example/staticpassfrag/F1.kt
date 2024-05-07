package com.example.staticpassfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class F1 : Fragment() {
    private lateinit var common: Common
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_f1, container, false)
        val sb = view.findViewById<Button>(R.id.sb)
        val et = view.findViewById<EditText>(R.id.et)
        common = activity as Common
        sb.setOnClickListener {
            common.pass(et.text.toString())
        }
        return view
    }
}