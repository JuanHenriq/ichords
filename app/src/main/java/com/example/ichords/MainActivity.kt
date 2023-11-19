package com.example.ichords

import HomeActivity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnlogin = findViewById<Button>(R.id.btn_login)
        val edUsername = findViewById<EditText>(R.id.ed_username)
        val edPassword = findViewById<EditText>(R.id.ed_password)


        val sharedPreferences = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val getUsername = sharedPreferences.getString("USERNAME", "")
        val getPassword = sharedPreferences.getString("PASSWORD", "")
        if (getUsername != "" && getPassword != "") {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }
        btnlogin.setOnClickListener {
            val username = edUsername.text.toString()
            val password = edPassword.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.apply()

            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)


        }
    }
}
