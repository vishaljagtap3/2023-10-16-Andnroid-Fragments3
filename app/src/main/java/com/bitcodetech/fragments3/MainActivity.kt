package com.bitcodetech.fragments3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var questionFragment: QuestionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        questionFragment = supportFragmentManager.findFragmentById(R.id.questionFragment) as QuestionFragment

    }

    //way 1
    fun setSelectedOption(selectedOption : String) {
        questionFragment.selectedOption = selectedOption
    }
}