package com.example.staticfragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Communicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uf = UpperFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fc,uf).commit()

    }
    override fun passData(EditTextargs: String) {
         val bundle= Bundle()
        bundle.putString("message", EditTextargs)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment1= LowerFragment()
        fragment1.arguments =bundle
        transaction.replace(R.id.fc, fragment1).commit()
    }
}