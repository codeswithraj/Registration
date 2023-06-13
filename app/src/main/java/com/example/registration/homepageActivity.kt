package com.example.registration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class homepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        val navigationBtn=findViewById<BottomNavigationView>(R.id.bottomnav)
        val logoutBtn=findViewById<Button>(R.id.logoutBtn)


        navigationBtn.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> loadFragment(homeFragment())
                R.id.setting -> loadFragment(settingFragment())
                R.id.profile -> loadFragment(profileFragment())

            }
            true
        }
        logoutBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
            val editUserPref = sharedPreferences.edit()
            editUserPref.putBoolean("userLogin",false)
            editUserPref.apply()
            startActivity(Intent(this,LoginActivity::class.java))

        }

    }
    private fun loadFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
    }
}