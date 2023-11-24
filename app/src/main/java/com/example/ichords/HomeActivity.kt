package com.example.ichords

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageViewBelow = findViewById<ImageView>(R.id.imageViewBelow)

        imageViewBelow.setOnClickListener {
            val splashIntent = Intent(this, SplashActivity::class.java)
            startActivity(splashIntent)

            Handler().postDelayed({

                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent)

                val startIntent = Intent(this, StartActivity::class.java)
                startActivity(startIntent)

                finish()
            }, 2000)
        }

        val imageViewClickable1 = findViewById<ImageView>(R.id.imageViewClickable1)
        imageViewClickable1.setOnClickListener {
            val bibliotecaIntent = Intent(this, BibliotecaActivity::class.java)
            startActivity(bibliotecaIntent)
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    true
                }
                R.id.menu_favorites -> {

                     startActivity(Intent(this, FavoritosActivity::class.java))
                    true
                }
                R.id.menu_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
