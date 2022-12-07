package com.example.premierleaguefixtures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.premierleaguefixtures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FirstFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.firstElem -> replaceFragment(FirstFragment())
                R.id.secondElem -> replaceFragment(SecondFragment())
            }
            true
        }

    }

    fun replaceFragment (fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}