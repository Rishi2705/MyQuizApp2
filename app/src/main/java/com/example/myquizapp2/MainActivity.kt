package com.example.myquizapp2

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var questionTextView: TextView? = null
    lateinit var totalQuestionTextView: TextView
    lateinit var ansA: Button
    lateinit var ansB: Button
    lateinit var ansC: Button
    lateinit var ansD: Button
    lateinit var btnSubmit: Button

    var score: Int = 0
    var totalQuestion: Int = QuestionAnswer.question.size
    var currentQuestionIndex: Int = 0
    var selectedAnswer: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalQuestionTextView = findViewById(R.id.total_questions)
        questionTextView = findViewById(R.id.questions)
        ansA = findViewById(R.id.ans_a)
        ansB = findViewById(R.id.ans_b)
        ansC = findViewById(R.id.ans_c)
        ansD = findViewById(R.id.ans_d)
        btnSubmit = findViewById(R.id.btn_submit)

        ansA.setOnClickListener(this)
        ansB.setOnClickListener(this)
        ansC.setOnClickListener(this)
        ansD.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        totalQuestionTextView.setText("Total question: $totalQuestion")

        loadNewQuestion()
    }

    private fun loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        questionTextView?.setText(QuestionAnswer.question.get(currentQuestionIndex))
        ansA.setText(QuestionAnswer.choices.get(currentQuestionIndex).get(0))
        ansB.setText(QuestionAnswer.choices.get(currentQuestionIndex).get(1))
        ansC.setText(QuestionAnswer.choices.get(currentQuestionIndex).get(2))
        ansD.setText(QuestionAnswer.choices.get(currentQuestionIndex).get(3))

        selectedAnswer = ""
    }

    private fun finishQuiz() {
        val passStatus = if (score >= totalQuestion * 0.6) {
            "Passed"
        } else {
            "Failed"
        }
        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Your Score is $score Out of $totalQuestion")
            .setPositiveButton(
                "Restart",
                (DialogInterface.OnClickListener { dialog: DialogInterface?, it: Int -> restartQuiz() })
            )
            .setCancelable(false)
            .show()
    }

    private fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    }

    override fun onClick(view: View) {
        ansA.setBackgroundColor(Color.WHITE)
        ansB.setBackgroundColor(Color.WHITE)
        ansC.setBackgroundColor(Color.WHITE)
        ansD.setBackgroundColor(Color.WHITE)

        val clickedButton = view as Button

        if (clickedButton.id == R.id.btn_submit) {
            if (!selectedAnswer.isEmpty()) {
                if (selectedAnswer == QuestionAnswer.correctAnswers.get(currentQuestionIndex)) {
                    score++
                } else {
                    clickedButton.setBackgroundColor(Color.MAGENTA)
                }
                currentQuestionIndex++
                loadNewQuestion()
            }else{

            }
        } else {
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.YELLOW)
        }
    }
}
