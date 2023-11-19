package com.example.ichords

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageViewBelow = findViewById<ImageView>(R.id.imageViewBelow)

        imageViewBelow.setOnClickListener {
            val splashIntent = Intent(this, SplashActivity::class.java)
            startActivity(splashIntent)

            Handler().postDelayed({
                // Volta para a HomeActivity
                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent)

                // Inicia a StartActivity após voltar para a HomeActivity
                val startIntent = Intent(this, StartActivity::class.java)
                startActivity(startIntent)

                // Fecha a HomeActivity
                finish()
            }, 2000)
        }
    }
}
