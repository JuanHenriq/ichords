package com.example.ichords

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val imageViewTopLeft = findViewById<ImageView>(R.id.imageViewTopRight)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        imageViewTopLeft.setOnClickListener {
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.menu_favorites -> {
                    // startActivity(Intent(this, FavoritosActivity::class.java))
                    true
                }
                R.id.menu_profile -> {
                    // Mantendo na tela de perfil
                    true
                }
                else -> false
            }
        }
    }
}
