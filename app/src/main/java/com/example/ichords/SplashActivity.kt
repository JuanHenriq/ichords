package com.example.ichords

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

            Handler().postDelayed({
            // Cria um Intent para iniciar a próxima atividade após o tempo determinado
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)

            // Fecha esta atividade (evita que o usuário volte à SplashActivity pressionando o botão Voltar)
            finish()
        }, SPLASH_TIME_OUT)
    }
}