package com.example.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottom_navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->replaceFragment(Home())
                R.id.profile->replaceFragment(Profile())
                R.id.settings->replaceFragment(Settings())
                R.id.exit->finish()
                else->{

                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }
}