package com.example.ichords

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList

class QuizActivity : AppCompatActivity() {

    lateinit var questionsList: ArrayList<QuestionModel>
    private var index: Int = 0
    lateinit var questionModel: QuestionModel

    private var correctAnswerCount: Int = 0
    private var wrongAnswerCount: Int = 0

    lateinit var countDown: TextView
    lateinit var questions: TextView
    lateinit var option1: Button
    lateinit var option2: Button
    lateinit var option3: Button
    lateinit var option4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.hide()

        questions = findViewById(R.id.questions)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        questionsList = ArrayList()
        questionsList.add(QuestionModel("Qual é a principal razão para manter os dedos arqueados ao tocar acordes no violão?", "Estilo visual", "Conforto", "Estabilidade e clareza sonora", "Moda", "Estabilidade e clareza sonora"))
        questionsList.add(QuestionModel("Em um acorde maior no violão, qual dedo geralmente pressiona a nota mais aguda?", "Dedo indicador", "Dedo médio", "Dedo anelar", "Dedo mínimo", "Dedo anelar"))
        questionsList.add(QuestionModel("Ao tocar um acorde de D maior no violão, qual dedo é geralmente utilizado para pressionar a terceira corda (corda B)?", "Dedo indicador", "Dedo médio", "Dedo anelar", "Dedo mínimo", "Dedo médio"))
        questionsList.add(QuestionModel("Qual é a principal diferença entre uma nota e um acorde no violão?", "Nota é um som único; acorde é uma combinação de notas", "Nota é mais alta que um acorde", "Nota é um acorde invertido", "Não há diferença, os termos são intercambiáveis", "Nota é um som único; acorde é uma combinação de notas"))
        questionsList.add(QuestionModel("Para um iniciante, qual acorde é geralmente recomendado aprender primeiro devido à sua simplicidade?", "C Maior", "G Maior", "D Maior", "E Maior", "C Maior"))

        questionModel = questionsList[index]
        setAllQuestions()
    }

    private fun setAllQuestions() {
        questions.text = questionModel.question
        option1.text = questionModel.option1
        option2.text = questionModel.option2
        option3.text = questionModel.option3
        option4.text = questionModel.option4
    }

    private fun correctAns(option: Button) {
        option.background = getDrawable(R.drawable.right_bg)
        correctAnswerCount++
        moveToNextQuestionWithDelay()
    }

    private fun wrongAns(option: Button) {
        option.background = resources.getDrawable(R.drawable.wrong_bg)
        when (questionModel.answer) {
            questionModel.option1 -> option1.background = resources.getDrawable(R.drawable.right_bg)
            questionModel.option2 -> option2.background = resources.getDrawable(R.drawable.right_bg)
            questionModel.option3 -> option3.background = resources.getDrawable(R.drawable.right_bg)
            questionModel.option4 -> option4.background = resources.getDrawable(R.drawable.right_bg)
        }

        wrongAnswerCount++
        moveToNextQuestionWithDelay()
    }

    private fun moveToNextQuestionWithDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            index++
            if (index < questionsList.size) {
                questionModel = questionsList[index]
                setAllQuestions()
                resetBackground()
                enableButton()
            } else {
                gameResult()
            }
        }, 1500)
    }

    private fun gameResult() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("correct", correctAnswerCount.toString())
        intent.putExtra("total", questionsList.size.toString())
        startActivity(intent)
        finish()
    }

    private fun enableButton() {
        option1.isClickable = true
        option2.isClickable = true
        option3.isClickable = true
        option4.isClickable = true
    }

    private fun disableButton() {
        option1.isClickable = false
        option2.isClickable = false
        option3.isClickable = false
        option4.isClickable = false
    }

    private fun resetBackground() {
        option1.background = resources.getDrawable(R.drawable.option_bg)
        option2.background = resources.getDrawable(R.drawable.option_bg)
        option3.background = resources.getDrawable(R.drawable.option_bg)
        option4.background = resources.getDrawable(R.drawable.option_bg)
    }

    fun option1Clicked(view: View) {
        disableButton()
        if (questionModel.option1 == questionModel.answer) {
            option1.background = resources.getDrawable(R.drawable.right_bg)
            correctAns(option1)
        } else {
            wrongAns(option1)
        }
    }

    fun option2Clicked(view: View) {
        disableButton()
        if (questionModel.option2 == questionModel.answer) {
            option2.background = resources.getDrawable(R.drawable.right_bg)
            correctAns(option2)
        } else {
            wrongAns(option2)
        }
    }

    fun option3Clicked(view: View) {
        disableButton()
        if (questionModel.option3 == questionModel.answer) {
            option3.background = resources.getDrawable(R.drawable.right_bg)
            correctAns(option3)
        } else {
            wrongAns(option3)
        }
    }

    fun option4Clicked(view: View) {
        disableButton()
        if (questionModel.option4 == questionModel.answer) {
            option4.background = resources.getDrawable(R.drawable.right_bg)
            correctAns(option4)
        } else {
            wrongAns(option4)
        }
    }
}
