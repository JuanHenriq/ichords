package com.example.ichords

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    lateinit var correctAns: TextView
    lateinit var totalAns: TextView
    lateinit var performance: TextView
    lateinit var output: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.hide()

        correctAns = findViewById(R.id.correctAns)
        totalAns = findViewById(R.id.totalAns)
        performance = findViewById(R.id.performance)
        output = findViewById(R.id.output)

        val intent = intent
        val correctAnsNo = intent.getStringExtra("correct")
        val totalAnsNo = intent.getStringExtra("total")
        correctAns.text = correctAnsNo
        totalAns.text = totalAnsNo

        val percentage = (correctAnsNo?.toFloat()?.div(totalAnsNo?.toFloat()!!))?.times(100)

        if (percentage != null) {
            when {
                50 <= percentage && percentage <= 99 -> {

                    performance.text = "BOM"


                }

                percentage >= 100 -> {
                    performance.text = "EXCELENTE"
                }

                percentage < 50 -> {
                    performance.text = "RUIM"
                }
            }


        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
}
