package com.example.registration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val user=findViewById<TextInputEditText>(R.id.username)
        val pass=findViewById<TextInputEditText>(R.id.password)
        val loginBtn=findViewById<Button>(R.id.loginbtn)
        val signUp = findViewById<TextView>(R.id.signup)

        signUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        val registerSharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val userName=registerSharedPreferences.getString("name","")
        val userPass=registerSharedPreferences.getString("password","")
        loginBtn.setOnClickListener {
            val user: String = user.text.toString()
            val pass: String = pass.text.toString()
            if (userName==user && userPass==pass) {
                val edit = registerSharedPreferences.edit()
                edit.putBoolean("userLogin", true)
                edit.apply()
                val intent = Intent(this,homepageActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(getApplicationContext(), "Username/Password Invalid", Toast.LENGTH_LONG).show();
            }
        }
        }

    }