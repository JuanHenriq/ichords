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
        questionsList.add(QuestionModel("Pergunta A", "Resposta A", "Resposta B", "Resposta C", "Resposta D", "Resposta A"))
        questionsList.add(QuestionModel("Pergunta B", "Resposta A", "Resposta B", "Resposta C", "Resposta D", "Resposta B"))
        questionsList.add(QuestionModel("Pergunta C?", "Resposta A", "Resposta B", "Resposta C", "Resposta D", "Resposta C"))
        questionsList.add(QuestionModel("Pergunta D?", "Resposta A", "Resposta B", "Resposta C", "Resposta D", "RESPOSTA D"))
        questionsList.add(QuestionModel("Pergunta E", "Resposta A", "Resposta B", "Resposta C", "Resposta D", "Resposta A"))

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
