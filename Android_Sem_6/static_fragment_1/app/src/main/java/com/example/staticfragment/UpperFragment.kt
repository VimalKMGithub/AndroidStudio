package com.example.staticfragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class UpperFragment : Fragment() {
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup
        ?,
        savedInstanceState: Bundle?): View?
    {
       val view= inflater.inflate(R.layout.fragment_upper, container, false)
        val btn: Button = view.findViewById(R.id.btnSend)
        val editText: EditText= view.findViewById(R.id.editText)
        communicator = activity as Communicator
        btn.setOnClickListener {
            communicator.passData(editText.text.toString())
        }
        return view
    }
}