package com.example.registration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
            val loginStatus =sharedPreferences.getBoolean("userLogin",false)
            if(loginStatus){
               startActivity(Intent(this,homepageActivity::class.java))
            }
            else{
                startActivity(Intent(this,LoginActivity::class.java))
            }
        },2000)
    }
}