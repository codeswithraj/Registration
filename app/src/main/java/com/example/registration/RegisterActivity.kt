package com.example.registration

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val signup=findViewById<TextView>(R.id.signin)
        val user =findViewById<TextInputEditText>(R.id.name)
        val number =findViewById<TextInputEditText>(R.id.contact)
        val email =findViewById<TextInputEditText>(R.id.email)
        val password =findViewById<TextInputEditText>(R.id.pass)
        val btn= findViewById<Button>(R.id.registerBtn)


        val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val sendData = sharedPreferences.edit()
        btn.setOnClickListener {
            sendData.putBoolean("userLogin", true)
            sendData.apply()
            sendData.putString("name",user.text.toString())
            sendData.putString("number",number.text.toString())
            sendData.putString("email",email.text.toString())
            sendData.putString("password",password.text.toString()).apply()
            startActivity(Intent(this,homepageActivity::class.java))
        }
        signup.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

}
}